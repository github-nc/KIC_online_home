<%-- 
    Document   : roomDetails
    Created on : Nov 14, 2020, 5:06:59 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Confirm the room added</title>
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
                <fieldset style="margin-top: 100px;">
                    <legend>New room added</legend>
                    <center>
                        <dl>
                            <dt style="margin-top:20px;">Room ID:</dt>
                            <dd>${requestScope.newRM.id}</dd>
                            <dt style="margin-top:10px;">Capacity:</dt>
                            <dd>${requestScope.newRM.capacity}</dd>
                        </dl>
                    </center>
                    <p class="right-btn">
                        <input type="button" value="Okay" onclick="document.getElementById('checkRoomList').click()">
                    </p>
                </fieldset>
                <a id="checkRoomList" href="checkRoom.form" style="visibility: hidden">Dashboard</a>
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>
