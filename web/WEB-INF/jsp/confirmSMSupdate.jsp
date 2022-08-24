<%-- 
    Document   : confirmSMSupdate
    Created on : Nov 26, 2020, 8:09:50 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Confirm the semester updated</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="css/styles.css" type="text/css"/>
    </head>

    <body>
        <div class="header">
            <h1>KIC Admin</h1>
        </div>
        <div class="row">
            <div class="col-4 col-s-4"></div>
            <div class="col-4 col-s-4">

                <fieldset style="margin-top:30px;">
                    <legend style="color:grey">Old semester info</legend>
                    <center>
                        <dl>
                            <dt style="margin-top:20px; color:grey;">Semester ID:</dt>
                            <dd style="color:grey;">${requestScope.oldSMS.id}</dd>
                            <dt style="margin-top:10px; color:grey;">Start Date:</dt>
                            <dd style="color:grey;">${requestScope.oldSMS.dateStart}</dd>
                            <dt style="margin-top:10px; color:grey;">End Date:</dt>
                            <dd style="color:grey;">${requestScope.oldSMS.dateEnd}</dd>
                        </dl>
                    </center>
                </fieldset>

                <fieldset style="margin-top:40px; border-color:grey;">
                    <legend style="color:green;">Updated to</legend>
                    <center>
                        <dl>
                            <dt style="margin-top:20px;">Semester ID:</dt>
                            <dd>${requestScope.updSMS.id}</dd>
                            <dt style="margin-top:10px;">Start Date:</dt>
                            <dd>${requestScope.updSMS.dateStart}</dd>
                            <dt style="margin-top:10px;">End Date:</dt>
                            <dd>${requestScope.updSMS.dateEnd}</dd>
                        </dl>
                    </center>
                    <p class="right-btn">
                        <input type="button" value="Okay" onclick="document.getElementById('checkSemesterList').click()">
                    </p>
                </fieldset>

                <a id="checkSemesterList" href="checkSemester.form" style="visibility: hidden">Dashboard</a>
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>

