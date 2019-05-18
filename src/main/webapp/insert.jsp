<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	<h1>Insert</h1>
	<ul>
		<li><a href="/appwebcrud/ServletIndex">Go to home</a></li>
	</ul>
	<%
	if(request.getAttribute("message")!=null){
		%>
		<b><%=request.getAttribute("message") %></b>
		<%
	}
	%>
	
	<form action="/appwebcrud/ServletInsert" method="post" >
		<label for="txtFirstName">FirstName</label>
		<input type="text" id="txtFirstName" name="txtFirstName">
		<br>
		<label for="txtLastName">LastName</label>
		<input type="text" id="txtLastName" name="txtLastName">
		<br>
		<label for="txtDocumentIdentification">Document Identification</label>
		<input type="text" id="txtDocumentIdentification" name="txtDocumentIdentification">
		<br>
		<label for="txtEmail">Email</label>
		<input type="text" id="txtEmail" name="txtEmail">
		<br>
		<label for="birthdate">Birthdate</label>
		<input type="date" id="birthDate" name="birthDate">
		<br>
		<input type="submit" value="Register person">
	</form>
	
</body>
</html>