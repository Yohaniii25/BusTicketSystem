<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		String id = request.getParameter("id");
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String Phone = request.getParameter("Phone");
		String DateOfBirth = request.getParameter("DateOfBirth");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
	%>
	
	<h1>Customer account delete</h1>
	
	<form action="delete" method="post">
	Customer ID : <input type = "text" name = "id" value="<%=id%>" readonly><br>
	Name : <input type = "text" name = "Name" value= "<%=Name%>" readonly><br>
	Address : <input type = "text" name = "Address" value = "<%=Address%> "readonly><br>
	Phone Number : <input type="text" name="Phone" value="<%=Phone%> "readonly><br>
	Date Of Birth : <input type="text" name="DateOfBirth" value="<%=DateOfBirth%>"readonly><br>
	Email : <input type="text" name="Email" value="<%=Email%>"readonly><br>
	
	
	<input type="Submit" name="Submit" value="Delete My Data"><br>
	
		
	</form>

</body>
</html>