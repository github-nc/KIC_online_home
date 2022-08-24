<%-- 
    Document   : semesterList
    Created on : Nov 25, 2020, 11:58:37 AM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Check semester list</title>
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
                <h1>Available semester list</h1>                
                <c:forEach items="${requestScope.sms}" var="sm">
                    <fieldset style="width: 500px; margin-bottom:20px;">                        
                        <legend style="color:darkcyan;">Semester information</legend>                        
                        <dl>
                            <dt style="margin-left: 150px;">Semester ID: ${sm.id}</dt>
                            <dd style="margin-left: 150px;">Start Date: ${sm.dateStart}</dd>
                            <dd style="margin-left: 150px;">End Date: ${sm.dateEnd}</dd>
                            <dd>
                                <form method="post" action="removeSMS.form">
                                    <input type="hidden" name="semid" value="${sm.id}">
                                    <button type="submit" class="clickBtn" style="margin-left: 110px;" onclick="return confirmRemove()">Remove</button>
                                </form>
                                <form method="post" action="getOldSMS.form">
                                    <input type="hidden" name="smId" value="${sm.id}">
                                    <input type="hidden" name="smDs" value="${sm.dateStart}">
                                    <input type="hidden" name="smDe" value="${sm.dateEnd}">
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
                    var rmv = confirm("Are you sure to remove this semester?");
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

