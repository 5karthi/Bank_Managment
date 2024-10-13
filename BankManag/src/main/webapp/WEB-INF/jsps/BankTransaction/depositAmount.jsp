
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Deposit Amount</title>
</head>
<body>
    <h1>Deposit Amount</h1>
    <form action="deposit" method="post">
        <label>Account ID: </label><input type="number" name="accountId" required><br>
        <label>Description: </label><input type="text" name="description" required><br>
        <label>Amount: </label><input type="number" step="0.01" name="amount" required><br>
        <input type="submit" value="Deposit">
    </form>
</body>
</html>