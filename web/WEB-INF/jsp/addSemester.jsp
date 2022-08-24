<%-- 
    Document   : addSemester
    Created on : Nov 18, 2020, 1:58:47 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>
    <head>
        <title>Add a semester</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" type="text/css"/>
    </head>

    <body>
        <div class="header">
            <h1>KIC Admin</h1>
        </div>
        <div class="row">
            <div class="col-4 col-s-4"></div>
            <div class="col-4 col-s-4">
                <c:forEach items="${requestScope.addSMSerrs}" var="ERR">
                    <dl style="font-size:12px;">
                        <dt>Error place: ${ERR.key}</dt>
                        <dd>Error type:  ${ERR.value}</dd>
                    </dl>
                </c:forEach>
                <form action="semester.save" method="post">
                    <fieldset style="margin-top: 20px;">
                        <legend>New semester</legend>
                        <p>
                            <label for="semsid" style="text-align:right;">Semester ID:&emsp;&emsp;&emsp;&emsp;</label>                            
                            <input type="text" id="semsid" name="smsID" pattern="[FS]+[123]{1,1}$" size="2" style="width:50px;" value="${param.smsID==null? '':param.smsID}" required>
                        </p>
                        <p>
                            <label for="startdate" style="text-align:right;">Start Date:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="date" id="startdate" name="startDate" value="${param.startDate==null? '':param.startDate}" required>
                        </p>
                        <p>
                            <label for="enddate" style="text-align:right;">End Date:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="date" id="enddate" name="endDate" value="${param.endDate==null? '':param.endDate}" required>
                        </p>
                        <p class="right-btn">
                            <input type="submit" value="Submit">
                            <input type="button" value="Cancel" onclick="document.getElementById('dashboardLink').click()">
                        </p>
                    </fieldset>                      
                </form>
                <a id="dashboardLink" href="dashboard.form" style="visibility: hidden">Dashboard</a>

                <dl style="color:gray; font-size:11px;">
                    <dt style="margin-bottom:3px;"><b>Rules for adding new semester</b></dt>
                    <dd>
                        <ol>
                            <li style="margin-bottom: 3px;">SemesterID is limited to 2 characters which must start with 'F' or 'S' and end with '1' or '2' or '3'.</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for F1: 10/11/2020~10/20/2020</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for F2: 12/11/2020~12/20/2020</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for F3: 02/11/2021~02/20/2021</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for S1: 04/11/2021~04/20/2021</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for S2: 06/11/2021~06/20/2021</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for S3: 08/11/2021~08/20/2021</li>
                            <li style="margin-bottom: 3px;">A valid term since the Start Date to the End Date is specified to be within 45~60 days.</li>
                        </ol>
                    </dd>
                </dl>
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>

