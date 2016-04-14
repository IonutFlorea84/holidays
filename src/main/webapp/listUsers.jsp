<%-- 
    Document   : listUsers
    Created on : Apr 13, 2016, 9:01:49 PM
    Author     : Owner
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ro.jademy.login.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</body>
</html>
