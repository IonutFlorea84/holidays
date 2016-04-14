<%-- 
    Document   : login
    Created on : Apr 13, 2016, 7:44:18 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <div id="logoHeader">
        <div id="logo">
            <img src="css/logo.png">
        </div>
    </div>
    
    
</head>
<body>
    <div id="style">
        <div align="center">
            <form action="login_form" method="post">
                <input type="text" name = "username" placeholder="Username"><br>
                <input type="password" name ="password" placeholder="Password"><br><br>
                <input type="submit" name="login" value="Login!">
                <input type="submit" name="register" value="Register">
            </form> 
                     
        </div>
    </div>
</body>
</html>
