<%-- 
    Document   : login
    Created on : Nov 4, 2020, 6:24:31 PM
    Author     : andx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Log-in page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="css/styles.css" type="text/css"/>

    </head>
    <body>
        <div class="header">
            <h1>Log-in Admin</h1>
        </div>
        <div class="row">
            <div class="col-4 col-s-4">
                <!--${sessionScope.error}-->
            </div>
            <div class="col-4 col-s-4">
                <form action="login.action" method="post">
                    <fieldset style="margin-top: 100px;">
                        <legend>Log in</legend>
                        <p>
                            <label for="userName">Login ID:</label>
                            <input type="text" id="userName" name="userName" required>
                        </p>
                        <p>
                            <label for="userName">Secret:</label>
                            <input type="password" id="secret" name="secret" required>
                        </p>
                        <p class="right-btn">
                            <input type="submit" value="Submit">
                        </p>
                    </fieldset>
                </form>
                <br><br>
                <%
                    String ER = (String) session.getAttribute("error");
                    if (ER != null) {
                        out.print("<p>" + ER + "</p>");
                        session.removeAttribute("error");
                        session.removeAttribute("userName");
                    }
                %>
                <!-- ${sessionScope.error} -->
            </div>
            <div class="col-4 col-s-4"></div>
        </div>        
        <div class="footer">
            <p>This is a trial version of the KIC admin on line. The developer Lingzhi-Andy-Xie will make this domain a better place.</p>
        </div>
    </body>
</html>
