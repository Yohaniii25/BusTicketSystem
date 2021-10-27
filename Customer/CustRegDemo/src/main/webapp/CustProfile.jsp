<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	
	<c:forEach var="cust" items="${customerDetails}">
	
	<c:set var = "id" value="${cust.id}"/>
	<c:set var = "Name" value="${cust.name }"/>
	<c:set var = "Address" value="${cust.address }"/>
	<c:set var = "Phone" value="${cust.phone }"/>
	<c:set var = "DateOfBirth" value="${cust.dateOfBirth }"/>
	<c:set var = "Email" value="${cust.email }"/>
	<c:set var = "Password" value="${cust.password }"/>
	
	<tr>
		<td>Customer ID</td>
		<td>${cust.id}</td>
	</tr>
	<tr>
		<td>Customer Name</td>
		<td>${cust.name}</td>
	</tr>
	<tr>
		<td>Customer Address</td>
		<td>${cust.address}</td>
	</tr>
	<tr>
	<tr>
		<td>Customer Phone Number</td>
		<td>${cust.phone}</td>
	</tr>
	<tr>
		<td>Customer Date of birth</td>
		<td>${cust.dateOfBirth }</td>
	</tr>
	<tr>
		<td>Customer Email</td>
		<td>${cust.email}</td>
	</tr>
	<tr>
		<td>Customer Password</td>
		<td>${cust.password }</td>
	</tr>
	
	</c:forEach>
	</table>
<!-- ------------------------------------------------------update----------------------------------------------------- -->
	
	<c:url value="UpdateCustomer.jsp" var="custupdate">
	<c:param name="id" value="${id }"/>
	<c:param name="Name" value="${Name }"/>
	<c:param name="Address" value="${Address }"/>
	<c:param name="Phone" value="${Phone }"/>
	<c:param name="DateOfBirth" value="${DateOfBirth }"/>
	<c:param name="Email" value="${Email }"/>
	<c:param name="Password" value="${Password }"/>
	</c:url>
	
	<a href="${custupdate}">
	<input type="button" name="update" value="Update My Data">
	</a>
	
	<!-- ------------------------------------------------------delete----------------------------------------------------- -->
	<br>
	
	<c:url value = "deletecustomer.jsp" var="cusdelete">
		<c:param name="id" value="${id }"></c:param>
		<c:param name="Name" value="${Name }"></c:param>
		<c:param name="Address" value="${Address }"></c:param>
		<c:param name="Phone" value="${Phone }"></c:param>
		<c:param name="DateOfBirth" value="${DateOfBirth }"></c:param>
		<c:param name="Email" value="${Email }"></c:param>
		<c:param name="Password" value="${Password }"></c:param>
	</c:url>
	<a href = "${cusdelete}">
	<br><input type="button" name="delete" value="Delete My Account">
	</a>
</body>
</html>














