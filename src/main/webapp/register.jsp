<%-- 
    Document   : register
    Created on : Apr 14, 2016, 2:51:04 PM
    Author     : Gabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page </title>
    </head>
    <body>

        <form action="register_form" method="post">
            <table>
                <tr> 
                    <td>Username:</td>
                    <td><input type="text" name = "username"></td>
                </tr>
                <tr> 
                    <td>Password:</td>
                    <td><input type="password" name ="password"></td>
                </tr> 
                <tr> 
                    <td>Name</td>
                    <td><input type="text" name = "name"></td>
                </tr>
                <tr> 
                    <td>Surname:</td>
                    <td><input type="text" name = "surname"></td>
                </tr>
                <tr> 
                    <td>Email:</td>
                    <td><input type="email" name = "email"></td>
                </tr>
                <tr> 
                    <td>Department:</td>
                    <td><input type="text" name = "department"></td>
                </tr>               
                <tr> 
                    <td>Hiring date:</td>
                    <td><input type="date" name = "hir_date"></td>
                </tr>               
                <tr> 
                    <td>Address:</td>
                    <td><input type="text" name = "adress"></td>
                </tr>               
                <tr> 
                    <td>Phone:</td>
                    <td><input type="number" name = "phone"></td>
                </tr>               
                <tr> 
                    <td>Gender:</td>
                    <td><input type="radio" name = "gender" value="male"> Male <input type="radio" name = "gender" value="female"> Female</td>
                </tr>          


            </table><br>
            <input type="submit" name="register" value="Register!">  
        </form>

    </body>
</html>
