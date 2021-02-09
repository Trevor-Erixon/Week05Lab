<%-- 
    Document   : home
    Created on : Feb 8, 2021, 10:52:13 AM
    Author     : Trevor Erixon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <form action="" method="get">
            <p>Hello ${username}.</p><br>
            <a href="login?logout">Log out</a>
            
        </form>
    </body>
</html>
