/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.models.Semester;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
public class SemesterController {

    public void processRequest(HttpServletRequest request, HttpServletResponse response, ServletContext application)
            throws ServletException, IOException, ParseException {

        String rqstUri = request.getRequestURI().trim();
        String dstUrl = rqstUri.substring(rqstUri.lastIndexOf("/") + 1);

        switch (dstUrl) {

            case "addSemstr.form":
                request.getRequestDispatcher("/WEB-INF/jsp/addSemester.jsp").forward(request, response);
                break;
            case "semester.save":
                HashMap<String, String> addSmsErrs = new HashMap<>();
                String SMSid = request.getParameter("smsID");
                String STARTdate = request.getParameter("startDate");
                String ENDdate = request.getParameter("endDate");
                System.out.println("Semester ID: " + SMSid);
                System.out.println("Input Start Date: " + STARTdate);
                System.out.println("Input End Date: " + ENDdate);

                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); //"YYYY-MM-DD" results false date parsing.
                Date start = fmt.parse(STARTdate);
                Date end = fmt.parse(ENDdate);
                int termDays = (int) ((end.getTime() - start.getTime()) / (60 * 60 * 24 * 1000) + 1);

                int n = 1;
                Calendar caldr = Calendar.getInstance();
                caldr.setTime(end);
                caldr.add(caldr.DATE, n); //把日期往后增加n天.正数往后推,负数往前移动 
                Date END = caldr.getTime();

                System.out.println("The start time is: " + start);
                System.out.println("The end time is: " + END + ""); //The + "" after end could be skipped.
                System.out.println("The period from the start time to the end time is: " + termDays + " days.");

                switch (SMSid) {

                    case "F1":
                        Date openDay1 = fmt.parse("2020-10-11");
                        Date shutDay1 = fmt.parse("2020-10-20");

                        if (start.getTime() < openDay1.getTime() || start.getTime() > shutDay1.getTime()) {
                            addSmsErrs.put("Start Date (" + STARTdate + ")", "The input Start Date is not matched with the Semester ID.");
                        }
                        if (termDays < 45 || termDays > 60) {
                            addSmsErrs.put("End Date (" + ENDdate + ")",
                                    "The term since the Start Date to the End Date is not in the range of 45~60 days.");
                        }

                        if (addSmsErrs.isEmpty()) {

                            Semester newsms = new Semester(SMSid, STARTdate, ENDdate);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.insertSemesterIntoDb(newsms);
                                request.setAttribute("newSMS", newsms);
                                request.getRequestDispatcher("/WEB-INF/jsp/semesterDetails.jsp").forward(request, response);

                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            request.setAttribute("addSMSerrs", addSmsErrs);
                            request.getRequestDispatcher("/WEB-INF/jsp/addSemester.jsp").forward(request, response);
                        }
                        break;

                    case "F2":
                        Date openDay2 = fmt.parse("2020-12-11");
                        Date shutDay2 = fmt.parse("2020-12-20");

                        if (start.getTime() < openDay2.getTime() || start.getTime() > shutDay2.getTime()) {
                            addSmsErrs.put("Start Date (" + STARTdate + ")", "The input Start Date is not matched with the Semester ID.");
                        }
                        if (termDays < 45 || termDays > 60) {
                            addSmsErrs.put("End Date (" + ENDdate + ")",
                                    "The term since the Start Date to the End Date is not in the range of 45~60 days.");
                        }

                        if (addSmsErrs.isEmpty()) {

                            Semester newsms = new Semester(SMSid, STARTdate, ENDdate);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.insertSemesterIntoDb(newsms);
                                request.setAttribute("newSMS", newsms);
                                request.getRequestDispatcher("/WEB-INF/jsp/semesterDetails.jsp").forward(request, response);

                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            request.setAttribute("addSMSerrs", addSmsErrs);
                            request.getRequestDispatcher("/WEB-INF/jsp/addSemester.jsp").forward(request, response);
                        }
                        break;

                    case "F3":
                        Date openDay3 = fmt.parse("2021-02-11");
                        Date shutDay3 = fmt.parse("2021-02-20");

                        if (start.getTime() < openDay3.getTime() || start.getTime() > shutDay3.getTime()) {
                            addSmsErrs.put("Start Date (" + STARTdate + ")", "The input Start Date is not matched with the Semester ID.");
                        }
                        if (termDays < 45 || termDays > 60) {
                            addSmsErrs.put("End Date (" + ENDdate + ")",
                                    "The term since the Start Date to the End Date is not in the range of 45~60 days.");
                        }

                        if (addSmsErrs.isEmpty()) {

                            Semester newsms = new Semester(SMSid, STARTdate, ENDdate);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.insertSemesterIntoDb(newsms);
                                request.setAttribute("newSMS", newsms);
                                request.getRequestDispatcher("/WEB-INF/jsp/semesterDetails.jsp").forward(request, response);

                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            request.setAttribute("addSMSerrs", addSmsErrs);
                            request.getRequestDispatcher("/WEB-INF/jsp/addSemester.jsp").forward(request, response);
                        }
                        break;

                    case "S1":
                        Date openDay4 = fmt.parse("2021-04-11");
                        Date shutDay4 = fmt.parse("2021-04-20");

                        if (start.getTime() < openDay4.getTime() || start.getTime() > shutDay4.getTime()) {
                            addSmsErrs.put("Start Date (" + STARTdate + ")", "The input Start Date is not matched with the Semester ID.");
                        }
                        if (termDays < 45 || termDays > 60) {
                            addSmsErrs.put("End Date (" + ENDdate + ")",
                                    "The term since the Start Date to the End Date is not in the range of 45~60 days.");
                        }

                        if (addSmsErrs.isEmpty()) {

                            Semester newsms = new Semester(SMSid, STARTdate, ENDdate);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.insertSemesterIntoDb(newsms);
                                request.setAttribute("newSMS", newsms);
                                request.getRequestDispatcher("/WEB-INF/jsp/semesterDetails.jsp").forward(request, response);

                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            request.setAttribute("addSMSerrs", addSmsErrs);
                            request.getRequestDispatcher("/WEB-INF/jsp/addSemester.jsp").forward(request, response);
                        }
                        break;

                    case "S2":
                        Date openDay5 = fmt.parse("2021-06-11");
                        Date shutDay5 = fmt.parse("2021-06-20");

                        if (start.getTime() < openDay5.getTime() || start.getTime() > shutDay5.getTime()) {
                            addSmsErrs.put("Start Date (" + STARTdate + ")", "The input Start Date is not matched with the Semester ID.");
                        }
                        if (termDays < 45 || termDays > 60) {
                            addSmsErrs.put("End Date (" + ENDdate + ")",
                                    "The term since the Start Date to the End Date is not in the range of 45~60 days.");
                        }

                        if (addSmsErrs.isEmpty()) {

                            Semester newsms = new Semester(SMSid, STARTdate, ENDdate);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.insertSemesterIntoDb(newsms);
                                request.setAttribute("newSMS", newsms);
                                request.getRequestDispatcher("/WEB-INF/jsp/semesterDetails.jsp").forward(request, response);

                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            request.setAttribute("addSMSerrs", addSmsErrs);
                            request.getRequestDispatcher("/WEB-INF/jsp/addSemester.jsp").forward(request, response);
                        }
                        break;

                    case "S3":
                        Date openDay6 = fmt.parse("2021-08-11");
                        Date shutDay6 = fmt.parse("2021-08-20");

                        if (start.getTime() < openDay6.getTime() || start.getTime() > shutDay6.getTime()) {
                            addSmsErrs.put("Start Date (" + STARTdate + ")", "The input Start Date is not matched with the Semester ID.");
                        }
                        if (termDays < 45 || termDays > 60) {
                            addSmsErrs.put("End Date (" + ENDdate + ")",
                                    "The term since the Start Date to the End Date is not in the range of 45~60 days.");
                        }

                        if (addSmsErrs.isEmpty()) {

                            Semester newsms = new Semester(SMSid, STARTdate, ENDdate);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.insertSemesterIntoDb(newsms);
                                request.setAttribute("newSMS", newsms);
                                request.getRequestDispatcher("/WEB-INF/jsp/semesterDetails.jsp").forward(request, response);

                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            request.setAttribute("addSMSerrs", addSmsErrs);
                            request.getRequestDispatcher("/WEB-INF/jsp/addSemester.jsp").forward(request, response);
                        }
                        break;

                    default:
                        break;
                }

                break;

            case "checkSemester.form":
                request.getRequestDispatcher("/WEB-INF/jsp/semesterList.jsp").forward(request, response);
                break;

            case "removeSMS.form":
                String semID = request.getParameter("semid");
                System.out.println("The ID of the semester which is going to be removed is:: " + semID + "");
                try {
                    dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                    dbCtr.removeSemesterFromDb(semID);
                    response.sendRedirect("checkSemester.form");
                } catch (SQLException ex) {
                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE,
                            "Error(s) occured when connecting to the database.", ex);
                    response.sendRedirect("dashboard.form");
                }
                break;

            case "getOldSMS.form":
                String oldSmId = request.getParameter("smId");
                String oldSmDs = request.getParameter("smDs");
                String oldSmDe = request.getParameter("smDe");
                request.setAttribute("oldSmID", oldSmId);
                request.setAttribute("oldSmDS", oldSmDs);
                request.setAttribute("oldSmDE", oldSmDe);
                request.getRequestDispatcher("/WEB-INF/jsp/oldSemesterInfo.jsp").forward(request, response);
                break;

            case "semester.update":
                HashMap<String, String> smUpdateErrs = new HashMap<>();

                String oldSmID = request.getParameter("oldSmId");
                String oldSmDS = request.getParameter("oldSmDs");
                String oldSmDE = request.getParameter("oldSmDe");

                String updatedSmId = request.getParameter("OldSmId");
                String updatedSmDs = request.getParameter("newSmDs");
                String updatedSmDe = request.getParameter("newSmDe");

                SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd"); //"YYYY-MM-DD" results false date parsing.
                Date newStart = SDF.parse(updatedSmDs);
                Date newEnd = SDF.parse(updatedSmDe);
                int periodDays = (int) ((newEnd.getTime() - newStart.getTime()) / (60 * 60 * 24 * 1000) + 1);

                System.out.println("The ID of the Semester expected to be updated is: " + updatedSmId);
                System.out.println("The expected new Start Date is: " + updatedSmDs);
                System.out.println("The expected new End Date is: " + updatedSmDe);
                System.out.println("The period from the expected new start date to the expected new end date is: " + periodDays + " days.");

                switch (updatedSmId) {

                    case "F1":
                        Date openDay1 = SDF.parse("2020-10-11");
                        Date shutDay1 = SDF.parse("2020-10-20");

                        if (newStart.getTime() < openDay1.getTime() || newStart.getTime() > shutDay1.getTime()) {
                            smUpdateErrs.put("Start Date (" + updatedSmDs + ")", "The expected new Start Date is not matched with the Semester ID.");
                        }
                        if (periodDays < 45 || periodDays > 60) {
                            smUpdateErrs.put("End Date (" + updatedSmDe + ")",
                                    "The term since the expected new Start Date to the expected new End Date is not in the range of 45~60 days.");
                        }

                        if (smUpdateErrs.isEmpty()) {
                            System.out.println("The ID of the semester which is going to be updated is: " + updatedSmId + "");
                            Semester oldSms = new Semester(oldSmID, oldSmDS, oldSmDE);
                            Semester updSms = new Semester(updatedSmId, updatedSmDs, updatedSmDe);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.updateSemesterIntoDb(updSms);
                                request.setAttribute("oldSMS", oldSms);
                                request.setAttribute("updSMS", updSms);
                                request.getRequestDispatcher("/WEB-INF/jsp/confirmSMSupdate.jsp").forward(request, response);
                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            request.setAttribute("semsUpdateErrs", smUpdateErrs);
                            request.setAttribute("oldSmID", oldSmID);
                            request.setAttribute("oldSmDS", oldSmDS);
                            request.setAttribute("oldSmDE", oldSmDE);
                            request.getRequestDispatcher("/WEB-INF/jsp/oldSemesterInfo.jsp").forward(request, response);
                        }
                        break;

                    case "F2":
                        Date openDay2 = SDF.parse("2020-12-11");
                        Date shutDay2 = SDF.parse("2020-12-20");

                        if (newStart.getTime() < openDay2.getTime() || newStart.getTime() > shutDay2.getTime()) {
                            smUpdateErrs.put("Start Date (" + updatedSmDs + ")", "The expected new Start Date is not matched with the Semester ID.");
                        }
                        if (periodDays < 45 || periodDays > 60) {
                            smUpdateErrs.put("End Date (" + updatedSmDe + ")",
                                    "The term since the expected new Start Date to the expected new End Date is not in the range of 45~60 days.");
                        }

                        if (smUpdateErrs.isEmpty()) {
                            System.out.println("The ID of the semester which is going to be updated is: " + updatedSmId + "");
                            Semester oldSms = new Semester(oldSmID, oldSmDS, oldSmDE);
                            Semester updSms = new Semester(updatedSmId, updatedSmDs, updatedSmDe);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.updateSemesterIntoDb(updSms);
                                request.setAttribute("oldSMS", oldSms);
                                request.setAttribute("updSMS", updSms);
                                request.getRequestDispatcher("/WEB-INF/jsp/confirmSMSupdate.jsp").forward(request, response);
                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            request.setAttribute("semsUpdateErrs", smUpdateErrs);
                            request.setAttribute("oldSmID", oldSmID);
                            request.setAttribute("oldSmDS", oldSmDS);
                            request.setAttribute("oldSmDE", oldSmDE);
                            request.getRequestDispatcher("/WEB-INF/jsp/oldSemesterInfo.jsp").forward(request, response);
                        }
                        break;

                    case "F3":
                        Date openDay3 = SDF.parse("2021-02-11");
                        Date shutDay3 = SDF.parse("2021-02-20");

                        if (newStart.getTime() < openDay3.getTime() || newStart.getTime() > shutDay3.getTime()) {
                            smUpdateErrs.put("Start Date (" + updatedSmDs + ")", "The expected new Start Date is not matched with the Semester ID.");
                        }
                        if (periodDays < 45 || periodDays > 60) {
                            smUpdateErrs.put("End Date (" + updatedSmDe + ")",
                                    "The term since the expected new Start Date to the expected new End Date is not in the range of 45~60 days.");
                        }

                        if (smUpdateErrs.isEmpty()) {
                            System.out.println("The ID of the semester which is going to be updated is: " + updatedSmId + "");
                            Semester oldSms = new Semester(oldSmID, oldSmDS, oldSmDE);
                            Semester updSms = new Semester(updatedSmId, updatedSmDs, updatedSmDe);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.updateSemesterIntoDb(updSms);
                                request.setAttribute("oldSMS", oldSms);
                                request.setAttribute("updSMS", updSms);
                                request.getRequestDispatcher("/WEB-INF/jsp/confirmSMSupdate.jsp").forward(request, response);
                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            request.setAttribute("semsUpdateErrs", smUpdateErrs);
                            request.setAttribute("oldSmID", oldSmID);
                            request.setAttribute("oldSmDS", oldSmDS);
                            request.setAttribute("oldSmDE", oldSmDE);
                            request.getRequestDispatcher("/WEB-INF/jsp/oldSemesterInfo.jsp").forward(request, response);
                        }
                        break;

                    case "S1":
                        Date openDay4 = SDF.parse("2021-04-11");
                        Date shutDay4 = SDF.parse("2021-04-20");

                        if (newStart.getTime() < openDay4.getTime() || newStart.getTime() > shutDay4.getTime()) {
                            smUpdateErrs.put("Start Date (" + updatedSmDs + ")", "The expected new Start Date is not matched with the Semester ID.");
                        }
                        if (periodDays < 45 || periodDays > 60) {
                            smUpdateErrs.put("End Date (" + updatedSmDe + ")",
                                    "The term since the expected new Start Date to the expected new End Date is not in the range of 45~60 days.");
                        }

                        if (smUpdateErrs.isEmpty()) {
                            System.out.println("The ID of the semester which is going to be updated is: " + updatedSmId + "");
                            Semester oldSms = new Semester(oldSmID, oldSmDS, oldSmDE);
                            Semester updSms = new Semester(updatedSmId, updatedSmDs, updatedSmDe);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.updateSemesterIntoDb(updSms);
                                request.setAttribute("oldSMS", oldSms);
                                request.setAttribute("updSMS", updSms);
                                request.getRequestDispatcher("/WEB-INF/jsp/confirmSMSupdate.jsp").forward(request, response);
                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            request.setAttribute("semsUpdateErrs", smUpdateErrs);
                            request.setAttribute("oldSmID", oldSmID);
                            request.setAttribute("oldSmDS", oldSmDS);
                            request.setAttribute("oldSmDE", oldSmDE);
                            request.getRequestDispatcher("/WEB-INF/jsp/oldSemesterInfo.jsp").forward(request, response);
                        }
                        break;

                    case "S2":
                        Date openDay5 = SDF.parse("2021-06-11");
                        Date shutDay5 = SDF.parse("2021-06-20");

                        if (newStart.getTime() < openDay5.getTime() || newStart.getTime() > shutDay5.getTime()) {
                            smUpdateErrs.put("Start Date (" + updatedSmDs + ")", "The expected new Start Date is not matched with the Semester ID.");
                        }
                        if (periodDays < 45 || periodDays > 60) {
                            smUpdateErrs.put("End Date (" + updatedSmDe + ")",
                                    "The term since the expected new Start Date to the expected new End Date is not in the range of 45~60 days.");
                        }

                        if (smUpdateErrs.isEmpty()) {
                            System.out.println("The ID of the semester which is going to be updated is: " + updatedSmId + "");
                            Semester oldSms = new Semester(oldSmID, oldSmDS, oldSmDE);
                            Semester updSms = new Semester(updatedSmId, updatedSmDs, updatedSmDe);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.updateSemesterIntoDb(updSms);
                                request.setAttribute("oldSMS", oldSms);
                                request.setAttribute("updSMS", updSms);
                                request.getRequestDispatcher("/WEB-INF/jsp/confirmSMSupdate.jsp").forward(request, response);
                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            request.setAttribute("semsUpdateErrs", smUpdateErrs);
                            request.setAttribute("oldSmID", oldSmID);
                            request.setAttribute("oldSmDS", oldSmDS);
                            request.setAttribute("oldSmDE", oldSmDE);
                            request.getRequestDispatcher("/WEB-INF/jsp/oldSemesterInfo.jsp").forward(request, response);
                        }
                        break;

                    case "S3":
                        Date openDay6 = SDF.parse("2021-08-11");
                        Date shutDay6 = SDF.parse("2021-08-20");

                        if (newStart.getTime() < openDay6.getTime() || newStart.getTime() > shutDay6.getTime()) {
                            smUpdateErrs.put("Start Date (" + updatedSmDs + ")", "The expected new Start Date is not matched with the Semester ID.");
                        }
                        if (periodDays < 45 || periodDays > 60) {
                            smUpdateErrs.put("End Date (" + updatedSmDe + ")",
                                    "The term since the expected new Start Date to the expected new End Date is not in the range of 45~60 days.");
                        }

                        if (smUpdateErrs.isEmpty()) {
                            System.out.println("The ID of the semester which is going to be updated is: " + updatedSmId + "");
                            Semester oldSms = new Semester(oldSmID, oldSmDS, oldSmDE);
                            Semester updSms = new Semester(updatedSmId, updatedSmDs, updatedSmDe);
                            try {
                                dbController dbCtr = (dbController) application.getAttribute("dbCtrl");
                                dbCtr.updateSemesterIntoDb(updSms);
                                request.setAttribute("oldSMS", oldSms);
                                request.setAttribute("updSMS", updSms);
                                request.getRequestDispatcher("/WEB-INF/jsp/confirmSMSupdate.jsp").forward(request, response);
                            } catch (SQLException ex) {
                                Logger.getLogger(SemesterController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            request.setAttribute("semsUpdateErrs", smUpdateErrs);
                            request.setAttribute("oldSmID", oldSmID);
                            request.setAttribute("oldSmDS", oldSmDS);
                            request.setAttribute("oldSmDE", oldSmDE);
                            request.getRequestDispatcher("/WEB-INF/jsp/oldSemesterInfo.jsp").forward(request, response);
                        }
                        break;

                    default:
                        break;
                }

                break;

            default:
                response.sendRedirect("dashboard.form");
                break;

        }

    }

}
