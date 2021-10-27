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

	<form action="update" method="post">
	Customer ID : <input type = "text" name = "id" value="<%=id%>" readonly><br>
	
	Name : <input type = "text" name = "Name" value= "<%=Name%>"><br>
	
	Address : <input type = "text" name = "Address" value = "<%=Address%>"><br>
	
	Phone Number : <input type="text" name="Phone" value="<%=Phone%>"><br>
	
	Date Of Birth : <input type="text" name="DateOfBirth" value="<%=DateOfBirth%>"><br>
	
	Email : <input type="text" name="Email" value="<%=Email%>"><br>
	
	Password : <input type="Password" name="Password" value="<%=Password%>"><br>
	
	<input type="Submit" name="Submit" value="Update My Data"><br>
	
		
	</form>

</body>
</html>