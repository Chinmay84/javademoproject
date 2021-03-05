<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<a href="addEmployee">Add Employee</a>
<c:if test="${not empty elist}">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="employee" items="${elist}">
			<tr>
			<td>${employee.id}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td><a href="editemployee/${employee.id}">Edit</a>/<a href="deleteemployee/${employee.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>