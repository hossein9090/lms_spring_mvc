<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Manager Home</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>


</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4"><div align="center">
            <h1>لیست کاربران</h1>
            <h3><a href="newUser">Add User</a></h3>
            <table border="1">
                <th>No</th>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>

                <c:forEach var="users" items="${userList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td style="color: red ;font-weight:bold">${users.id}</td>
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
        </div></div>
        <div class="col-md-4"><div align="center">
            <h1>جدول واسط</h1>
            <h3><a href="newBorrow">Add Borrowing </a></h3>
            <table border="1">
                <th>No</th>
                <th>ID</th>
                <th>User_id</th>
                <th>Book_id</th>

                <c:forEach var="borrows" items="${borrowList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td style="color: red ;font-weight:bold">${borrows.id}</td>
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
        </div></div>
        <div class="col-md-4"><div align="center">
            <h1>لیست کتاب ها</h1>
            <h3><a href="newBook">Add Book</a></h3>
            <table border="1">
                <th>No</th>
                <th>ID</th>
                <th>Name</th>
                <th>Author_Name</th>


                <c:forEach var="books" items="${bookList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td style="color: red ;font-weight:bold">${books.id}</td>
                        <td>${books.name}</td>
                        <td>${books.authorName}</td>
                        <td>
                            <a href="editBook?id=${books.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="deleteBook?id=${books.id}">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div></div>
    </div>
</div>
<div align="center">
</div>
</body>
</html>

