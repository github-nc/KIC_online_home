/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andx
 */
public class LogoutController {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.getSession().invalidate();
        response.sendRedirect("index.html");
        
    }
    
}
