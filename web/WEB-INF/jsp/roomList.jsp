<%-- 
    Document   : roomList
    Created on : Nov 24, 2020, 8:40:22 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Check room list</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
    </head>
    <body>

        <div class="header">
            <span><h1 style="padding-top: 15px;">KIC Admin</h1>
                <p style="direction: rtl" class="rtLink"><a href="dashboard.form">Go to dashboard</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Welcome ${sessionScope.userName}<span id="logoutAlert">(<a href="logout.form">logout</a>)</span></p>
            </span>
        </div>

        <div class="row">

            <div class="col-4 col-s-4 menu1"></div>     


            <div class="col-4 col-s-4">
                <h1>Lecture room list</h1>                
                <c:forEach items="${requestScope.rms}" var="rm">
                    <fieldset style="width: 500px; margin-bottom:20px;">                        
                        <legend style="color:darkcyan;">Room information</legend>                        
                        <dl>
                            <dt style="margin-left: 150px;">Room ID: ${rm.id}</dt>
                            <dd style="margin-left: 150px;">Capacity: ${rm.capacity}</dd>
                            <dd>
                                <form method="post" action="removeRM.form">
                                    <input type="hidden" name="rmid" value="${rm.id}">
                                    <button type="submit" class="clickBtn" style="margin-left: 110px;" onclick="return confirmRemove()">Remove</button>
                                </form>
                                <form method="post" action="getOldRM.form">
                                    <input type="hidden" name="rmid" value="${rm.id}">
                                    <input type="hidden" name="rmcap" value="${rm.capacity}">
                                    <button type="submit" class="clickBtn">Update</button>
                                </form> 
                            </dd>                                       
                        </dl>                          
                    </fieldset>
                </c:forEach>
            </div>


            <div class="col-4  col-s-4 menu2"></div>

            <script>
                function confirmRemove() {
                    var rmv = confirm("Are you sure to remove this room?");
                    if (rmv) {
                        return true;
                    } else {
                        return false;
                    }
                }

            </script>

        </div>

        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>

    </body>
</html>
