<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Borrow Book</title>
</head>
<body>
<div align="center">
    <h1>New/Edit Borrow Book</h1>
    <form:form action="saveBorrow" method="post" modelAttribute="newBorrow">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>userId:</td>
                <td><form:input path="userId" /></td>
            </tr>
            <tr>
                <td>bookId:</td>
                <td><form:input path="bookId" /></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>