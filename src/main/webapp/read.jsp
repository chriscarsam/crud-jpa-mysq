<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
</head>
<body>

	<h1>Read</h1>
	<ul>
	<li><a href="/appwebcrud/ServletIndex">Go to home</a></li>
	</ul>
	<table border="1" >
		<thead>	
			<tr>
			<th>FIRSTNAME</th>
			<th>LASTNAME</th>
			<th>DOCUMENT IDENTIFICATION</th>
			<th>EMAIL</th>
			<th>BIRTHDATE</th>
			<th>REGISTRATION DATE</th>
			<th>UPDATE DATE</th>
			<th></th>
			<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${listPerson}">
				<tr>
					<td><c:out value="${item.getFirstName()}" ></c:out></td>
					<td><c:out value="${item.getLastName()}" ></c:out></td>
					<td><c:out value="${item.getDocumentIdentification()}" ></c:out></td>
					<td><c:out value="${item.getEmail()}" ></c:out></td>
					<td><c:out value="${item.getBirthdate()}" ></c:out></td>
					<td><c:out value="${item.getRegistrationDate()}" ></c:out></td>
					<td><c:out value="${item.getUpdateDate()}" ></c:out></td>
					<td><input type="button" value="Delete" onclick="dele('${item.getId()}')"></td>
					<td><input type="button" value="Edit" onclick="edit('${item.getId()}')"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
<script>
	function dele(id) {
		window.location.href="/appwebcrud/ServletDelete?id="+id;
	}

	function edit(id) {
		window.location.href="/appwebcrud/ServletUpdate?id="+id;
	}
</script>
</html>