
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Account</title>
</head>
<body>
    <h1>Update Account Details</h1>
    <form action="updateAccount" method="post">
        <label>Account ID: </label><input type="number" name="accountId" required><br>
        <label>New Name: </label><input type="text" name="customerName"><br>
        <label>New Email: </label><input type="email" name="customerEmail"><br>
        <label>New Phone: </label><input type="text" name="customerPhone"><br>
        <input type="submit" value="Update Account">
    </form>
</body>
</html>
