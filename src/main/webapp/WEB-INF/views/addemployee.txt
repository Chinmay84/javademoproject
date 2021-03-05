<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<div>

<form:form method="post" >
<div>
<form:label path="id">ID</form:label>
<form:input path="id"/>
<form:errors pathname="id"></form:errors>
</div>
<div>
<form:label path="firstName">First Name</form:label>
<form:input path="firstName"/>
<form:errors pathname="firstName"></form:errors>
</div>
<div>

<form:label path="lastName">Last Name</form:label>
<form:input path="lastName"/>
<form:errors pathname="lastName"></form:errors>
</div>
<form:button type="submit">Add Student</form:button>
</form:form>
</div>
</body>
</html>