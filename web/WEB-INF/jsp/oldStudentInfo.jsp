<%-- 
    Document   : oldStudentInfo
    Created on : Nov 24, 2020, 1:58:51 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Update a student</title>
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
                <c:forEach items="${requestScope.stUpdateErrs}" var="ERR">
                    <dl>
                        <dt>Error place: ${ERR.key}</dt>
                        <dd>Error type:  ${ERR.value}</dd>
                    </dl>
                </c:forEach>

                <form action="student.update" method="post">                    
                    <fieldset style="margin-top: 30px; border-color:#ebebeb;">
                        <legend style="color:gray">Old student info</legend>
                        <p>
                            <label for="oldSTID" style="color:gray; text-align:right;">Student ID:&emsp;&emsp;&emsp;&emsp;</label>                            
                            <input type="number" id="oldSTID" name="oldStId" value="${requestScope.oldStID}" readonly="readonly" style="color:gray;" required>
                        </p>
                        <p>
                            <label for="oldSTNM" style="color: gray; text-align:right;">Name:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="text" id="oldSTNM" name="oldStNm" value="${requestScope.oldStNM}" readonly="readonly" style="color:gray;" required>
                        </p>   
                        <p>
                            <label for="oldSTLANG" style="color: gray; text-align:right;">Language:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="text" id="oldSTLANG" name="oldStLang" value="${requestScope.oldStLANG}" readonly="readonly" style="color:gray;" required>
                        </p> 
                    </fieldset>

                    <fieldset style="margin-top: 40px;">
                        <legend style="color:green;">Update to</legend>
                        <p>
                            <label for="OldSTID" style="text-align:right;">Student ID:&emsp;&emsp;&emsp;&emsp;</label>                            
                            <input type="number" id="OldSTID" name="OldStId" value="${requestScope.oldStID}" readonly="readonly" required>                          
                        </p>
                        <p>
                            <label for="newSTNM" style="text-align:right;">Name:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="text" id="newSTNM" name="newStNm" value="${param.newStNm==null? '':param.newStNm}" required>
                        </p>
                        <p>
                            <label for="newSTLANG" style="text-align:right;">Language:&emsp;&emsp;&emsp;&emsp;</label>
                            <select id="newSTLANG" name="newStLang" style="width:145px;" required>
                                <option value="None" selected disabled hidden>Select a language</option> 
                                <option value="English" <c:if test="${requestScope.newSTLANG eq 'English'}">selected="selected"</c:if>>English</option>
                                <option value="Japanese" <c:if test="${requestScope.newSTLANG eq 'Japanese'}">selected="selected"</c:if>>Japanese</option>
                            </select><!-- It's expected to retain the selected option after erroneous submission, but it appears to be not functional. -->

                        </p>

                        <p class="right-btn">
                            <input type="submit" value="Submit">
                            <input type="button" value="Cancel" onclick="document.getElementById('checkStudentList').click()">
                        </p>
                    </fieldset>
                </form>
                <a id="checkStudentList" href="checkStudent.form" style="visibility: hidden">Dashboard</a>
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>

