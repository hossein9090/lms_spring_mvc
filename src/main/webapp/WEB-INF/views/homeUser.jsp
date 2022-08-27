<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>User List</h1>
	        <h3><a href="newUser">New User</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>ID</th>
	        	<th>First Name</th>
	        	<th>Last Name</th>
	        	<th>Address</th>


<%--				//TODO--%>

				<c:forEach var="users" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
	        		<td>${users.id}</td>
					<td>${users.FName}</td>
					<td>${users.LName}</td>
					<td>${users.address}</td>
					<td>
						<a href="editUser?id=${users.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteUser?id=${users.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
