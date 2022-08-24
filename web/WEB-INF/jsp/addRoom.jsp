<%-- 
    Document   : addRoom
    Created on : Nov 4, 2020, 9:27:08 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Add a room</title>
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
                <c:forEach items="${requestScope.addRMerrs}" var="ERR">
                    <dl>
                        <dt>Error place: ${ERR.key}</dt>
                        <dd>Error type:  ${ERR.value}</dd>
                    </dl>
                </c:forEach>
                <form action="room.save" method="post">
                    <fieldset style="margin-top: 50px;">
                        <legend>New room</legend>
                        <p>
                            <label for="roomid">Room ID:</label>                            
                            <input type="text" id="roomid" name="roomId" value="${param.roomId==null? '':param.roomId}" required> 
                        </p>
                        <p>
                            <label for="roomcap">Capacity:</label>
                            <input type="number" id="roomcap" name="roomCap" value="${param.roomCap==null? '':param.roomCap}" required>
                        </p>
                        <p class="right-btn">
                            <input type="submit" value="Submit">
                            <input type="button" value="Cancel" onclick="document.getElementById('dashboardLink').click()">
                        </p>
                    </fieldset>
                </form>
                <a id="dashboardLink" href="dashboard.form" style="visibility: hidden">Dashboard</a>
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>

