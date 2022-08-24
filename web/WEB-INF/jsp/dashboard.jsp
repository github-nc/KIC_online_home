<%-- 
    Document   : dashboard
    Created on : Nov 4, 2020, 8:19:49 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome on board</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
    </head>
    <body>

        <div class="header">
            <span><h1 style="padding-top: 15px;">KIC Admin</h1><p style="direction: rtl" class="logoutAlert0">Welcome ${sessionScope.userName}(<a href="logout.form">logout</a>)</p></span>
        </div>

        <div class="row">

            <div class="col-4 col-s-4" style="padding-right: 13px;">
                <div class="menu1">
                    <ul>
                        <li style="margin-top: 32px;"><a href="addRM.form" style="text-decoration: none; margin-left: 40px;">Add a room</a></li>
                        <li><a href="addSemstr.form" style="text-decoration: none; margin-left: 40px;">Add a semester</a></li>
                        <li><a href="addCourse.form" style="text-decoration: none; margin-left: 40px;">Add a course</a></li>
                        <li><a href="multi-courses.form" style="text-decoration: none; margin-left: 40px;">Add multiple courses</a></li>
                        <li><a href="addStudent.form" style="text-decoration: none; margin-left: 40px;">Add a student</a></li>
                        <li><a href="enrollment.form" style="text-decoration: none; margin-left: 40px;">Enroll students in courses</a></li>
                    </ul>
                </div>

                <div class="menu3" style="margin-top: -20px;">
                    <ul>
                        <li><a href="link1" style="text-decoration: none; margin-left: 40px;">Sample of hyper link1</a></li>
                        <li><a href="link2" style="text-decoration: none; margin-left: 40px;">Sample of hyper link2</a></li>
                        <li><a href="link3" style="text-decoration: none; margin-left: 40px;">Sample of hyper link3</a></li>
                        <li><a href="link4" style="text-decoration: none; margin-left: 40px;">Sample of hyper link4</a></li>
                    </ul>
                </div>  

            </div>     

            <div class="col-4 col-s-4">
                <h1>KIC Lecture Rooms</h1>
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
                <p></p>
                <p></p>
                <p></p>
                <p></p>
            </div>

            <div class="col-4  col-s-4">    
                <div class="menu2" style="margin-left: 60px;">
                    <ul>
                        <li style="margin-top: 32px"><a href="checkRoom.form" style="text-decoration:none; color:black; margin-left:40px;">Check the room list</a></li>
                        <li><a href="checkSemester.form" style="text-decoration:none; color:black; margin-left:40px;">Check the semester list</a></li>
                        <li><a href="courseXXXXXX" style="text-decoration:none; color:black; margin-left:40px;">Check the course list</a></li>
                        <li><a href="multi-coursesXXXXXX" style="text-decoration:none; color:black; margin-left:40px;">Check the course list</a></li>
                        <li><a href="checkStudent.form" style="text-decoration:none; color:black; margin-left:40px;">Check the student list</a></li>
                        <li><a href="enrollmentXXXXXX" style="text-decoration:none; color:black; margin-left:40px;">Check the enrollment list</a></li>
                    </ul>
                </div>
                
                <div class="MsgBox">
                    <p style="line-height:150%;">
                        <span style="color:darkcyan">Leave your message here:</span><br>
                        The developer prefers to design a message board in this area. 
                        But the problem is he has no idea with how to achieve this function with codes by now ... 
                        How to do it? How to make it? Dear my God, please send body to help me out ... 
                    </p>
                </div>    

            </div>

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
            <p>Welcome on board! This is a trial version of the KIC admin on line. Improving is underway.</p>
        </div>

    </body>
</html>

