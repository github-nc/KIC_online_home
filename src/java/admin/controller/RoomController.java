/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.models.Room;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andx
 */
public class RoomController {

    /*
    public void processRequest(HttpServletRequest request, HttpServletResponse response, ServletContext application) throws IOException, ServletException {

        if (request.getMethod().equalsIgnoreCase("get")) {
            request.getRequestDispatcher("/WEB-INF/jsp/addRoom.jsp").forward(request, response);
        } else if (request.getMethod().equalsIgnoreCase("post")) {
            //check match via database connection
            //if there is match, redirect to roomDetails.form ---> DispatcherServlet --> roomDetails.jsp ???               
        }

    }
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response, ServletContext application)
            throws ServletException, IOException {

        String rqstUri = request.getRequestURI().trim();
        String dstUrl = rqstUri.substring(rqstUri.lastIndexOf("/") + 1);

        switch (dstUrl) {

            case "addRM.form":
                request.getRequestDispatcher("/WEB-INF/jsp/addRoom.jsp").forward(request, response);
                break;

            case "room.save":
                HashMap<String, String> addRoomErrs = new HashMap<>();
                String rmId = request.getParameter("roomId");
                if (rmId == null || (!rmId.matches("[a-zA-Z]{1,2}"))) {
                    addRoomErrs.put("RoomID (" + rmId + ")",
                            "RoomID can not be empty and its length is limited to 1~2 English letters in the range of 'a-z & A-Z'.");
                }
                int rmCap = Integer.parseInt(request.getParameter("roomCap"));
                if (rmCap < 1 || rmCap > 40) {
                    addRoomErrs.put("Capacity (" + rmCap + ")",
                            "Capacity should be a positive integer not more than 40.");
                }
                if (addRoomErrs.isEmpty()) {
                    Room newrm = new Room(rmId, rmCap);
                    try {
                        dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                        dbCtr.insertRoomIntoDb(newrm);
                        request.setAttribute("newRM", newrm);
                        request.getRequestDispatcher("/WEB-INF/jsp/roomDetails.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE,
                                "Error(s) occured when connecting to the database.", ex);
                        response.sendRedirect("dashboard.form");
                    }
                } else {
                    request.setAttribute("addRMerrs", addRoomErrs);
                    request.getRequestDispatcher("/WEB-INF/jsp/addRoom.jsp").forward(request, response); //why not use redirect?
                }
                break;

            case "checkRoom.form":
                request.getRequestDispatcher("/WEB-INF/jsp/roomList.jsp").forward(request, response);
                break;

            case "removeRM.form":
                String RMID = (String) request.getParameter("rmid");
                System.out.println("The ID of the room which is going to be removed is: " + RMID + "");
                try {
                    dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                    dbCtr.removeRoomFromDb(RMID);
                    response.sendRedirect("checkRoom.form");
                } catch (SQLException ex) {
                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE,
                            "Error(s) occured when connecting to the database.", ex);
                    response.sendRedirect("dashboard.form");
                }
                break;

            case "getOldRM.form":
                String oldRoomId = request.getParameter("rmid");
                int oldCapacity = Integer.parseInt(request.getParameter("rmcap"));
                request.setAttribute("oldRMID", oldRoomId);
                request.setAttribute("oldRMCAP", oldCapacity);
                //application.setAttribute("oldRMID", oldRoomId);
                //application.setAttribute("oldCAP", oldCapacity);
                request.getRequestDispatcher("/WEB-INF/jsp/oldRMinformation.jsp").forward(request, response);
                break;

            case "room.update":
                HashMap<String, String> RMupdateErrs = new HashMap<>();

                String oldRMid = request.getParameter("roomID");
                int oldRMcap = Integer.parseInt(request.getParameter("roomCAP"));

                String updatedRMid = request.getParameter("rmID");
                int updatedRMcap = Integer.parseInt(request.getParameter("rmCAP"));

                if (updatedRMcap < 1 || updatedRMcap > 40) {
                    RMupdateErrs.put("Capacity (" + updatedRMcap + ")",
                            "Capacity should be a positive integer not more than 40.");
                }
                if (RMupdateErrs.isEmpty()) {
                    System.out.println("The ID of the room which is going to be updated is: " + updatedRMid + "");
                    Room oldrm = new Room(oldRMid, oldRMcap);
                    Room nrm = new Room(updatedRMid, updatedRMcap);
                    try {
                        dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                        dbCtr.updateRoomIntoDb(nrm);
                        request.setAttribute("ORM", oldrm);
                        request.setAttribute("NRM", nrm);
                        request.getRequestDispatcher("/WEB-INF/jsp/confirmRMupdate.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE,
                                "Error(s) occured when connecting to the database.", ex);
                        response.sendRedirect("dashboard.form");
                    }
                } else {
                    request.setAttribute("rmUpdateErrs", RMupdateErrs);
                    request.setAttribute("oldRMID", oldRMid); //indispensable for display old information after erroneous submission
                    request.setAttribute("oldRMCAP", oldRMcap); //indispensable for display old information after erroneous submission
                    request.getRequestDispatcher("/WEB-INF/jsp/oldRMinformation.jsp").forward(request, response); //why not use redirect?
                }
                break;

            default:
                response.sendRedirect("dashboard.form");
                break;

        }
    }
}
