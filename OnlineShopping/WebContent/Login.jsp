<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page </title>
</head>
<body>
<center>
<form action="CustomerController?action=Login" method="post">
<input type="hidden" action=Login>
<h2>Login Details</h2>
Username:<input type="text" name="username"><br><br>
Password:<input type="password" name="password"><br><br>
<input type="submit" value="Submit">
<a href="Registration.jsp">New User Register here..</a>
 </form>
 </center>
</body>
</html>