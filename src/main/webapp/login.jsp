<%-- 
    Document   : login
    Created on : Apr 13, 2016, 7:44:18 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <div id="logoHeader">
        <div id="logo">
            <img src="logo.png">
        </div>
    </div>
    <style  type="text/css">
        #style {
            position: absolute;
            top: 30%;
            left: 0px;
            right: 0px;
            height: 100px;
            margin-top: -70px;
            background: #1FC4E7;
            color: white;
            padding: 20px;
        }
        #logoHeader {
            margin: auto;
            width: 40%;
            height: 30%;
            border: 3px solid #1FC4E7;
            padding: 10px;
        } 
        #logo {
            margin: auto;
            width: 40%;
        }
    </style>
    <title>Login Page</title>
</head>
<body>
    <!--<h1>Hello World!</h1>-->
    <div id="style">
        <div align="center">
            <form action="login_form" method="post">

                Username:<input type="text" name = "username"><br>
                Password: <input type="password" name ="password"><br><br>
                <input type="submit" name="login" value="Login!">
              

            </form> 
               <a href="register.jsp">
                   <button>Register</button>
               </a>    

                    
        </div>
    </div>
</body>
</html>
