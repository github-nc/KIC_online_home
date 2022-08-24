<%-- 
    Document   : oldRMstatus
    Created on : Nov 16, 2020, 11:16:50 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Update a room</title>
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
                <c:forEach items="${requestScope.rmUpdateErrs}" var="ERR">
                    <dl>
                        <dt>Error place: ${ERR.key}</dt>
                        <dd>Error type:  ${ERR.value}</dd>
                    </dl>
                </c:forEach>

                <form action="room.update" method="post">                    
                    <fieldset style="margin-top: 30px; border-color:#ebebeb;">
                        <legend style="color:gray">Old room info</legend>
                        <p>
                            <label for="roomId" style="color:gray;">Room ID:</label>                            
                            <input type="text" id="roomid" name="roomID" value="${requestScope.oldRMID}" readonly="readonly" style="color:gray;" required>
                        </p>
                        <p>
                            <label for="roomCap" style="color: gray;">Capacity:</label>
                            <input type="number" id="roomcap" name="roomCAP" value="${requestScope.oldRMCAP}" readonly="readonly" style="color:gray;" required>
                        </p>                       
                    </fieldset>

                        <fieldset style="margin-top: 40px;">
                        <legend style="color:green;">Update to</legend>
                        <p>
                            <label for="roomId">Room ID:</label>                            
                            <input type="text" id="RoomId" name="rmID" value="${requestScope.oldRMID}" readonly="readonly" required>                          
                        </p>
                        <p>
                            <label for="roomCap">Capacity:</label>
                            <input type="number" id="RoomCap" name="rmCAP" value="${param.rmCAP==null? '':param.rmCAP}" required>
                        </p>
                        <p class="right-btn">
                            <input type="submit" value="Submit">
                            <input type="button" value="Cancel" onclick="document.getElementById('checkRoomList').click()">
                        </p>
                    </fieldset>
                </form>
                <a id="checkRoomList" href="checkRoom.form" style="visibility: hidden">Dashboard</a>
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>
