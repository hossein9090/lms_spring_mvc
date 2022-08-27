<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit User</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit User</h1>
		<form:form action="saveUser" method="post" modelAttribute="newUser">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>First Name:</td>
				<td><form:input path="FName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="LName" /></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>