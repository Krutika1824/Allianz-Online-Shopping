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
<m:mydateformat pattern="dd/MM/yyyy" value="12/03/2019"></m:mydateformat>
<form action="ProductController" method="post">
<c:if test="${param.action eq 'edit'}">
<input type="hidden" value="update" name="action">
</c:if>
<c:if test="${param.action eq 'null'}">
<input type="hidden" value="save" name="action"></c:if>
<input type="hidden" name="id" id="id" value="${product.id}">
<table border="2">
<tr>
<td>ID</td>
<td><input type="text" disabled="disabled" value="${product.id}"></td>
</tr>

<tr>
<td>CODE</td>
<td><input type="text" name="code" id="code" value="${product.code}"></td>
</tr>

<tr>
<td>DESCRIPTION</td>
<td><input type="text" name="des" id="des"  value="${product.description}"></td>
</tr>

<tr>
<td>PRICE</td>
<td><input type="text" name="price" id="price" value="${product.price}"></td>
</tr>

<tr>
<td>DATE</td>
<fmt:formatDate value="${product.manfdate}" pattern="dd/MM/yyyy" var="manfDate"/>
<td><input type="text" name="date" id="date" value="${manfDate}"></td>
</tr>

<tr>
<td><input type="Submit"></td>
<td><input type="Reset"></td>
</tr>

</table>

</form>
</body>
</html>