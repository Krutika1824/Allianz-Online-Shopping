<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Order Details....
<c:forEach items="${orderdetails}" var="order">
<table border="2">
<tr>
<th>OrderId</th>
<th>OrderDate</th>
<th>Status</th>
<th>Total Price</th>
<th>Username</th>


</tr>
<tr>
<td>${order.orderId}</td>
<td>${order.orderDate}</td>
<td>${order.status}</td>
<td>${order.totalPrice}</td> 
<td>${order.username}</td>

</tr>
</table>

</c:forEach> 
</body>
</html>