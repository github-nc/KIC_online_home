/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dispatcher;

import admin.controller.CourseController;
import admin.controller.DashboardController;
import admin.controller.LoginController;
import admin.controller.LogoutController;
import admin.controller.RoomController;
import admin.controller.SemesterController;
import admin.controller.StudentController;
import admin.controller.dbController;
/*Need manually add up with typing*/
import java.sql.SQLException;
/*Need manually add up with typing*/
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
/*Need manually add up with typing*/
import java.util.logging.Logger;
/*Need manually add up with typing*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andx
 */
public class DispatcherServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = request.getRequestURI();
            String resource = url.substring(url.lastIndexOf("/"));
            //http://KIC_online/login.form  [ an example for parsing URI ]
            switch (resource) {

                case "/login.form":
                case "/login.action":
                    new LoginController().processRequest(request, response, getServletContext());
                    break;

                case "/logout.form":
                    new LogoutController().processRequest(request, response);
                    break;

                case "/dashboard.form":
                    new DashboardController().processRequest(request, response, getServletContext());
                    break;

                case "/addRM.form":
                case "/room.save":
                case "/checkRoom.form":
                case "/removeRM.form":
                case "/getOldRM.form":
                case "/room.update":
                    new RoomController().processRequest(request, response, getServletContext());
                    break;

                case "/addSemstr.form":
                case "/semester.save":
                case "/checkSemester.form":
                case "/removeSMS.form":
                case "/getOldSMS.form":
                case "/semester.update":
                    new SemesterController().processRequest(request, response, getServletContext());
                    break;

                case "/addStudent.form":
                case "/student.save":
                case "/checkStudent.form":
                case "/removeStudent.form":
                case "/getOldStudent.form":
                case "/student.update":
                    new StudentController().processRequest(request, response, getServletContext());
                    break;
                    
                case "/addCourse.form":
                    new CourseController().processRequest(request, response, getServletContext());
                    break;

                    
                    
                default:
                    response.sendRedirect("login.form");
                    break;

            }
        } catch (ParseException ex) {
            Logger.getLogger(DispatcherServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DispatcherServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            //response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            //response.sendRedirect("dashboard.form");
        } catch (SQLException ex) {
            Logger.getLogger(DispatcherServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void init() throws ServletException {
        // ServletContext application = this.getServletContext();
        /* try {
            //Make sure that SQLite JDBC driver class is present
            Class.forName("org.sqlite.JDBC");
            //Enforce foreign keys in sqlite
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            //Start a connection to the DB
            Connection connection1 = DriverManager.getConnection("jdbc:sqlite:/Users/Developer/kic_admin.db3", config.toProperties());
            application.setAttribute("dbConnect1", connection1);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DispatcherServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        super.init();

        try {

            dbController dbCtrl = new dbController("/Users/Developer/kic_admin.db3");
            this.getServletContext().setAttribute("dbCtrl", dbCtrl);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DispatcherServlet.class.getName()).log(Level.SEVERE, "Database driver not found. Please check your jars", ex);
        } catch (SQLException ex) {
            Logger.getLogger(DispatcherServlet.class.getName()).log(Level.SEVERE, "Error(s) occured when connecting to the database.", ex);
        }

    }

}
