/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.models.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andx
 */
public class StudentController {

    public void processRequest(HttpServletRequest request, HttpServletResponse response, ServletContext application)
            throws ServletException, IOException {

        String rqstUri = request.getRequestURI().trim();
        String dstUrl = rqstUri.substring(rqstUri.lastIndexOf("/") + 1);

        switch (dstUrl) {
            case "addStudent.form":
                request.getRequestDispatcher("/WEB-INF/jsp/addStudent.jsp").forward(request, response);
                break;

            case "student.save":
                HashMap<String, String> addStdErrs = new HashMap<>();

                int stdID = Integer.parseInt(request.getParameter("studentId"));
                if (stdID < 19001 || stdID > 23999) {
                    addStdErrs.put("Student ID (" + stdID + ")",
                            "Student ID must be an integer in the scope of 19001~23999.");
                }

                String stdNM = request.getParameter("studentName");
                if (stdNM.length() < 3) {
                    addStdErrs.put("Name (" + stdNM + ")",
                            "Student name can't be shorter than 3 characters");
                }

                String stdLang = (String) request.getParameter("Lang");
                if (stdLang.equals("None")) {
                    addStdErrs.put("Language (" + stdLang + ")",
                            "Language must be set to English or Japanese.");
                }

                if (addStdErrs.isEmpty()) {
                    Student newstd = new Student(stdID, stdNM, stdLang);
                    try {
                        dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                        dbCtr.insertStudentIntoDb(newstd);
                        request.setAttribute("newStd", newstd);
                        request.getRequestDispatcher("/WEB-INF/jsp/studentDetails.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE,
                                "Error(s) occured when connecting to the database.", ex);
                        response.sendRedirect("dashboard.form");
                    }

                } else {
                    System.out.println(addStdErrs);
                    System.out.println(stdLang);
                    request.setAttribute("addSTDerrs", addStdErrs);
                    request.getRequestDispatcher("/WEB-INF/jsp/addStudent.jsp").forward(request, response);
                }

                break;

            case "checkStudent.form":
                request.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp").forward(request, response);
                break;

            case "removeStudent.form":
                int stdId = Integer.parseInt(request.getParameter("stdid"));

                System.out.println("The ID of the student which is going to be removed is:: " + stdId + "");
                try {
                    dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                    dbCtr.removeStudentFromDb(stdId);
                    response.sendRedirect("checkStudent.form");
                } catch (SQLException ex) {
                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE,
                            "Error(s) occured when connecting to the database.", ex);
                    response.sendRedirect("dashboard.form");
                }
                break;

            case "getOldStudent.form":
                int oldSTid = Integer.parseInt(request.getParameter("stid"));
                String oldSTnm = request.getParameter("stnm");
                String oldSTlang = request.getParameter("stlang");
                request.setAttribute("oldStID", oldSTid);
                request.setAttribute("oldStNM", oldSTnm);
                request.setAttribute("oldStLANG", oldSTlang);
                request.getRequestDispatcher("/WEB-INF/jsp/oldStudentInfo.jsp").forward(request, response);
                break;

            case "student.update":
                HashMap<String, String> StUpdateErrs = new HashMap<>();

                int oldStdId = Integer.parseInt(request.getParameter("oldStId"));
                String oldStdNm = request.getParameter("oldStNm");
                String oldStdLang = request.getParameter("oldStLang");

                int updatedStdId = Integer.parseInt(request.getParameter("OldStId"));
                String updatedStdNm = request.getParameter("newStNm");
                String updatedStdLang = request.getParameter("newStLang");

                if (updatedStdNm.length() < 3) {
                    StUpdateErrs.put("Name (" + updatedStdNm + ")",
                            "Student name can't be shorter than 3 characters");
                }

                if (StUpdateErrs.isEmpty()) {
                    System.out.println("The ID of the student which is going to be updated is: " + updatedStdId + "");
                    Student oldSt = new Student(oldStdId, oldStdNm, oldStdLang);
                    Student newSt = new Student(updatedStdId, updatedStdNm, updatedStdLang);
                    try {
                        dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                        dbCtr.updateStudentIntoDb(newSt);
                        request.setAttribute("oldST", oldSt);
                        request.setAttribute("newST", newSt);
                        request.getRequestDispatcher("/WEB-INF/jsp/confirmSTDupdate.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE,
                                "Error(s) occured when connecting to the database.", ex);
                        response.sendRedirect("dashboard.form");
                    }
                } else {
                    request.setAttribute("stUpdateErrs", StUpdateErrs);
                    request.setAttribute("oldStID", oldStdId);
                    request.setAttribute("oldStNM", oldStdNm);
                    request.setAttribute("oldStLANG", oldStdLang);
                    request.getRequestDispatcher("/WEB-INF/jsp/oldStudentInfo.jsp").forward(request, response); //why not use redirect?
                }
                break;

            default:
                response.sendRedirect("dashboard.form");
                break;

        }

    }

}
