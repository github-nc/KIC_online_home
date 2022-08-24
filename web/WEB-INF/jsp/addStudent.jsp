<%-- 
    Document   : addStudent
    Created on : Nov 22, 2020, 12:03:03 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Add a student</title>
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
                <c:forEach items="${requestScope.addSTDerrs}" var="ERR">
                    <dl>
                        <dt>Error place: ${ERR.key}</dt>
                        <dd>Error type:  ${ERR.value}</dd>
                    </dl>
                </c:forEach>
                <form action="student.save" method="post">
                    <fieldset style="margin-top: 50px;">
                        <legend>New student</legend>
                        <p>
                            <label for="stdId" style="text-align:right;">Student ID:&emsp;&emsp;&emsp;&emsp;</label>                            
                            <input type="number" id="stdId" name="studentId" value="${param.studentId==null? '':param.studentId}" required> 
                        </p>
                        <p>
                            <label for="stdName" style="text-align:right;">Name:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="text" id="stdName" name="studentName" value="${param.studentName==null? '':param.studentName}" required>
                        </p>
                        <p>
                            <label for="lang" style="text-align:right;">Language:&emsp;&emsp;&emsp;&emsp;</label>
                            <select id="lang" name="Lang" style="width:145px;" required>
                                <option value="None"></option>
                                <option value="English">English</option>
                                <option value="Japanese">Japanese</option>
                            </select> <!-- How to retain the selected item after erroneous submission? -->
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

