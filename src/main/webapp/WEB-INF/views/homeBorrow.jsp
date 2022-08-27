<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Borrow Book Manager Home</title>
</head>
<body>
<div align="center">
    <h1>Borrow List</h1>
    <h3><a href="newBorrow">New Borrowing </a></h3>
    <table border="1">
        <th>No</th>
        <th>ID</th>
        <th>User_id</th>
        <th>Book_id</th>

        <c:forEach var="borrows" items="${borrowList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${borrows.id}</td>
                <td>${borrows.userId}</td>
                <td>${borrows.bookId}</td>
                <td>
                    <a href="editBorrow?id=${borrows.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deleteBorrow?id=${borrows.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
