<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<center>
<form action="CustomerController?action=Register" method="post">

<h2>Customer Details</h2>
Fisrtname:<input type="text" name="fname"><br><br>
Lastname:<input type="text" name="lname"><br><br>
Email:<input type="text" name="email"><br><br>
Username:<input type="text" name="username" ><br><br>
Password:<input type="password" name="password"><br><br>
<input type="Submit" value="Register">
</form>
</center>
</body>
</html>