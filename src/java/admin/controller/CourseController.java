/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andx
 */
public class CourseController {

    public void processRequest(HttpServletRequest request, HttpServletResponse response, ServletContext application)
            throws ServletException, IOException {

        String rqstUri = request.getRequestURI().trim();
        String dstUrl = rqstUri.substring(rqstUri.lastIndexOf("/") + 1);

        switch (dstUrl) {

            case "addCourse.form":
                request.getRequestDispatcher("/WEB-INF/jsp/addCourse.jsp").forward(request, response);
                break;

            default:
                response.sendRedirect("dashboard.form");
                break;
        }

    }

}
