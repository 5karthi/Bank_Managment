<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Check Balance</title>
</head>
<body>
    <h1>Check Balance</h1>
    <form action="checkBalance" method="get">
        <label>Account ID: </label><input type="number" name="accountId" required><br>
        <input type="submit" value="Check Balance">
    </form>
</body>
</html>
