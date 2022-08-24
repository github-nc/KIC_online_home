package admin.filter;

import admin.controller.dbController;
import admin.models.Room;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andx
 */
public class DashboardFilter implements Filter {

    protected FilterConfig filterCfg;

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
            ArrayList<Room> rooms = new ArrayList<>();
            
            try (ResultSet rslt = dbContrl.fetchRoomsFromDb()) {
                while (rslt.next()) {
                    rooms.add(new Room(rslt.getString("rm_id"), rslt.getInt("rm_capacity")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("rms", rooms);
            chain.doFilter(request, response);
            
        } else {
            ((HttpServletResponse) response).sendRedirect("login.form");
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
        Logger.getLogger(DashboardFilter.class.getName()).log(Level.INFO, "DashboardFilter: Intializing filter ...");
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        return ("DashboardFilter()");
    }

}
