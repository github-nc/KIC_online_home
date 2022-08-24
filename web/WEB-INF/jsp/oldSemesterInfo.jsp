<%-- 
    Document   : oldSemesterInfo
    Created on : Nov 26, 2020, 1:01:25 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Update a semester</title>
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
                <c:forEach items="${requestScope.semsUpdateErrs}" var="ERR">
                    <dl style="font-size:12px;">
                        <dt>Error place: ${ERR.key}</dt>
                        <dd>Error type:  ${ERR.value}</dd>
                    </dl>
                </c:forEach>

                <form action="semester.update" method="post">                    
                    <fieldset style="margin-top: 30px; border-color:#ebebeb;">
                        <legend style="color:gray">Old semester info</legend>
                        <p>
                            <label for="oldSMID" style="color:gray; text-align:right;">Semester ID:&emsp;&emsp;&emsp;&emsp;</label>                            
                            <input type="text" id="oldSMID" name="oldSmId" value="${requestScope.oldSmID}" readonly="readonly" style="color:gray;" required>
                        </p> <!-- 如果type="number", type与${requestScope.oldSmID}的String类型不匹配, SemesterController.java里的属性"oldSmID"的值将无法传递到此处 -->
                        <p>
                            <label for="oldSMDS" style="color: gray; text-align:right;">Start Date:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="text" id="oldSMDS" name="oldSmDs" value="${requestScope.oldSmDS}" readonly="readonly" style="color:gray;" required>
                        </p>   
                        <p>
                            <label for="oldSMDE" style="color: gray; text-align:right;">End Date:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="text" id="oldSMDE" name="oldSmDe" value="${requestScope.oldSmDE}" readonly="readonly" style="color:gray;" required>
                        </p> 
                    </fieldset>

                    <fieldset style="margin-top: 40px;">
                        <legend style="color:green;">Update to</legend>
                        <p>
                            <label for="OldSMID" style="text-align:right;">Semester ID:&emsp;&emsp;&emsp;&emsp;</label>                            
                            <input type="text" id="OldSMID" name="OldSmId" value="${requestScope.oldSmID}" readonly="readonly" required>                          
                        </p>
                        <p>
                            <label for="newSMDS" style="text-align:right;">Start Date:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="date" id="newSMDS" name="newSmDs" value="${param.newSmDs==null? '':param.newSmDs}" required>
                        </p>

                        <p>
                            <label for="newSMDE" style="text-align:right;">End Date:&emsp;&emsp;&emsp;&emsp;</label>
                            <input type="date" id="newSMDE" name="newSmDe" value="${param.newSmDe==null? '':param.newSmDe}" required>
                        </p>              

                        <p class="right-btn">
                            <input type="submit" value="Submit">
                            <input type="button" value="Cancel" onclick="document.getElementById('checkSemesterList').click()">
                        </p>
                    </fieldset>
                </form>
                <a id="checkSemesterList" href="checkSemester.form" style="visibility: hidden">Dashboard</a>
                
                <dl style="color:gray; font-size:11px;">
                    <dt style="margin-bottom:3px;"><b>Rules for updating new room</b></dt>
                    <dd>
                        <ol>                            
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for F1: 10/11/2020~10/20/2020</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for F2: 12/11/2020~12/20/2020</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for F3: 02/11/2021~02/20/2021</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for S1: 04/11/2021~04/20/2021</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for S2: 06/11/2021~06/20/2021</li>
                            <li style="margin-bottom: 3px;">Legitimate Start Date picking for S3: 08/11/2021~08/20/2021</li>
                            <li style="margin-bottom: 3px;">A valid term since the Start Date to the End Date is specified to be within 45~60 days.</li>
                        </ol>
                    </dd>
                </dl>
                                
            </div>
            <div class="col-4 col-s-4"></div>
        </div>
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>

</html>



