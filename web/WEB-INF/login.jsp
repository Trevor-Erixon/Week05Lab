<%-- 
    Document   : login
    Created on : Feb 8, 2021, 10:51:52 AM
    Author     : Trevor Erixon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="" method="post">
            <p><b>${logoutMessage}</b></p>
            Username: <input type="text" name="username">  <i>${usernameMessage}</i><br>
            Password: <input type="password" name="password">  <i>${passwordMessage}</i><br><br>
            <input type="submit" value="Log in">
        </form>
    </body>
</html>
