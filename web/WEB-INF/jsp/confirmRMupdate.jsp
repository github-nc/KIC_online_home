<%-- 
    Document   : confirmRMupdate
    Created on : Nov 18, 2020, 12:44:27 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Confirm the room updated</title>
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
                    <legend style="color:grey">Old room info</legend>
                    <center>
                        <dl>
                            <dt style="margin-top:20px; color:grey;">Room ID:</dt>
                            <dd style="color:grey;">${requestScope.ORM.id}</dd>
                            <dt style="margin-top:10px; color:grey;">Capacity:</dt>
                            <dd style="color:grey;">${requestScope.ORM.capacity}</dd>
                        </dl>
                    </center>
                </fieldset>

                <fieldset style="margin-top:40px; border-color:grey;">
                    <legend style="color:green;">Updated to</legend>
                    <center>
                        <dl>
                            <dt style="margin-top:20px;">Room ID:</dt>
                            <dd>${requestScope.NRM.id}</dd>
                            <dt style="margin-top:10px;">Capacity:</dt>
                            <dd>${requestScope.NRM.capacity}</dd>
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
