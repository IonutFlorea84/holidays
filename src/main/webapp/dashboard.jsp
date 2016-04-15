<%-- 
    Document   : dashboard
    Created on : Apr 14, 2016, 9:57:53 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ro.jademy.login.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>

        <link rel="stylesheet" type="text/css" href="css/login.css">
        
    <div id="logoHeader">
        <div id="logo">
            <img src="css/logo.png">
        </div>
    </div>
</head>
<body>
    <h1>${result}</h1>
    
    <ul>
        <li><a href ="#home" >Home</a></li>
        <li><a href="#listUsers">List Users</a></li>
        
        <div id ="table">

    <table>
        <thead>
        <td>
            <b>Username</b>
        </td>
        <td>
            <b>Name</b>
        </td>
        <td>
            <b>Surname</b>
        </td>
        <td>
            <b>Gender</b>
        </td>
        </thead>
        
        <c:forEach items="${list}" var="item">
            <tr>
                <td>
                    ${item.username}
                </td>
                <td>
                    ${item.name}
                </td>
                <td>
                    ${item.surname}
                </td>
                <td>
                    ${item.gender}
                </td>

            </tr>
        </c:forEach>

    </table>
</div>
        
    </ul>
</body>
</html>