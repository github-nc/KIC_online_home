<%-- 
    Document   : confirmSTDupdate
    Created on : Nov 24, 2020, 6:40:14 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Confirm the student updated</title>
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
                    <legend style="color:grey">Old student info</legend>
                    <center>
                        <dl>
                            <dt style="margin-top:20px; color:grey;">Student ID:</dt>
                            <dd style="color:grey;">${requestScope.oldST.id}</dd>
                            <dt style="margin-top:10px; color:grey;">Name:</dt>
                            <dd style="color:grey;">${requestScope.oldST.name}</dd>
                            <dt style="margin-top:10px; color:grey;">Language:</dt>
                            <dd style="color:grey;">${requestScope.oldST.lang}</dd>
                        </dl>
                    </center>
                </fieldset>

                <fieldset style="margin-top:40px; border-color:grey;">
                    <legend style="color:green;">Updated to</legend>
                    <center>
                        <dl>
                            <dt style="margin-top:20px;">Student ID:</dt>
                            <dd>${requestScope.newST.id}</dd>
                            <dt style="margin-top:10px;">Name:</dt>
                            <dd>${requestScope.newST.name}</dd>
                            <dt style="margin-top:10px;">Language:</dt>
                            <dd>${requestScope.newST.lang}</dd>
                        </dl>
                    </center>
                    <p class="right-btn">
                        <input type="button" value="Okay" onclick="document.getElementById('checkStudentList').click()">
                    </p>
                </fieldset>

                <a id="checkStudentList" href="checkStudent.form" style="visibility: hidden">Dashboard</a>
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>
