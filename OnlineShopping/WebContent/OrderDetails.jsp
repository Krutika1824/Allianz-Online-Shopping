<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
</head>
<body>
<c:forEach items="${orderdetails}" var="orderdetails">
<table border=2>
<tr>
<td>${orderdetails.orderId}</td>
<td>${orderdetails.orderDate}</td>
</tr>

<c:forEach items="${orderdetails.addToCartList}" var="addtocartlist">
<tr>
<td>${addtocartlist.quantity}</td>
<td>${addtocartlist.total}</td>
</tr>
</c:forEach>
</table>
</c:forEach>




</body>
</html>