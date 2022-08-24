<%-- 
    Document   : studentList
    Created on : Nov 23, 2020, 9:33:14 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Check student list</title>
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
                <h1>Registered student list</h1>                
                <c:forEach items="${requestScope.stds}" var="std">
                    <fieldset style="width: 500px; margin-bottom:20px;">                        
                        <legend style="color:darkcyan;">Student information</legend>                        
                        <dl>
                            <dt style="margin-left: 150px;">Student ID: ${std.id}</dt>
                            <dd style="margin-left: 150px;">Name: ${std.name}</dd>
                            <dd style="margin-left: 150px;">Language: ${std.lang}</dd>
                            <dd>
                                <form method="post" action="removeStudent.form">
                                    <input type="hidden" name="stdid" value="${std.id}">
                                    <button type="submit" class="clickBtn" style="margin-left: 110px;" onclick="return confirmRemove()">Remove</button>
                                </form>
                                <form method="post" action="getOldStudent.form">
                                    <input type="hidden" name="stid" value="${std.id}">
                                    <input type="hidden" name="stnm" value="${std.name}">
                                    <input type="hidden" name="stlang" value="${std.lang}">
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
                    var rmv = confirm("Are you sure to remove this student?");
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


