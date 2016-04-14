<%-- 
    Document   : listUsers
    Created on : Apr 13, 2016, 9:01:49 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Listing</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="css/listStyle.css">
    <div id="logoHeader">
        <div id="logo">
            <img src="css/logo.png">
        </div>
    </div>
</head>
<body>
    <center>
        <h1>${result}</h1><br>
    </center>
    <div id ="table">
        ${userlist}
    </div>
</body>
</html>
