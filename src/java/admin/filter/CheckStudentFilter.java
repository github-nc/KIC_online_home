/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.filter;

import admin.controller.dbController;
import admin.models.Room;
import admin.models.Student;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author andx
 */
public class CheckStudentFilter implements Filter {

    private FilterConfig filterCfg;

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        ServletContext appl = filterCfg.getServletContext();
        HttpServletRequest httpRqst = (HttpServletRequest) request;

        if (httpRqst.getSession().getAttribute("userName") != null) {

            dbController dbContrl = (dbController) appl.getAttribute("dbCtrl");
            ArrayList<Student> students = new ArrayList<>();

            try (ResultSet rslt = dbContrl.fetchStudentsFromDb()) {
                while (rslt.next()) {
                    students.add(new Student(rslt.getInt("std_id"), rslt.getString("std_name"), rslt.getString("std_lang")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardFilter.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("stds", students);
            chain.doFilter(request, response);

        } else {
            ((HttpServletResponse) response).sendRedirect("dashboard.form");
        }

    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterCfg = filterConfig;
        Logger.getLogger(CheckStudentFilter.class.getName()).log(Level.INFO, "CheckStudentFilter: Intializing filter ...");
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {

        return ("CheckStudentFilter()");
    }

}
