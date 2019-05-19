<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

	<h1>Update</h1>
	<ul>
	<li><a href="/appwebcrud/ServletIndex">Go to home</a></li>
	</ul>
	<jsp:useBean id="person" class="com.sambcode.app.bean.Person" scope="request"></jsp:useBean>
	<form action="/appwebcrud/ServletUpdate" method="post" >
			<input type="hidden" id="txtId" name="txtId" value="<%=person.getId()%>" >
			<label for="txtFirstName">FirstName</label>
			<input type="text" id="txtFirstName" name="txtFirstName" value="<%=person.getFirstName()%>">
			<br>
			<label for="txtLastName">LastName</label>
			<input type="text" id="txtLastName" name="txtLastName" value="<%=person.getLastName()%>">
			<br>
			<label for="txtDocumentIdentification">Document Identification</label>
			<input type="text" id="txtDocumentIdentification" name="txtDocumentIdentification" value="<%=person.getDocumentIdentification()%>">
			<br>
			<label for="txtEmail">Email</label>
			<input type="text" id="txtEmail" name="txtEmail" value="<%=person.getEmail()%>">
			<br>
			<label for="birthdate">Birthdate</label>
			<input type="date" id="birthDate" name="birthDate" value="<%=person.getBirthdate()%>">
			<br>
			<input type="submit" value="Edit person">
		</form>
</body>
</html>