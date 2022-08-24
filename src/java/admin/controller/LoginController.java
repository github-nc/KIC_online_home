/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import java.sql.Statement;    /*Need manually add up with typing*/
import java.sql.ResultSet;    /*Need manually add up with typing*/
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andx
 */
public class LoginController {

    public void processRequest(HttpServletRequest request, HttpServletResponse response, ServletContext application)
            throws IOException, ServletException {
        if (request.getMethod().equalsIgnoreCase("get")) {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } else if (request.getMethod().equalsIgnoreCase("post")) {
            try {
                String userName = request.getParameter("userName");
                String secret = request.getParameter("secret");

                HttpSession session = request.getSession(true);
                Connection connection2 = (Connection) application.getAttribute("dbConnect2");
                if (connection2 == null) {
                    connection2 = DriverManager.getConnection("jdbc:sqlite:/Users/Developer/login.db3");
                    application.setAttribute("dbConnect2", connection2);
                }

                Statement stmnt = connection2.createStatement();
                String qry = "select * from users where user_name = '" + userName + "' and secret = '" + secret + "';";
                ResultSet rslt = stmnt.executeQuery(qry);

                if (rslt.next()) {
                    session.setAttribute("userName", userName);
                    response.sendRedirect("dashboard.form");
                } else {
                    session.setAttribute("error", "Couldn't find a match for the credentials you typed.");
                    response.sendRedirect("login.form");
                }

            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Sorry, the HTTP method used is not supported!");

        }

    }

}
