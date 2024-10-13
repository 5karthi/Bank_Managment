
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fund Transfer</title>
</head>
<body>
    <h1>Fund Transfer</h1>
    <form action="fundTransfer" method="post">
        <label>Sender Account ID: </label><input type="number" name="senderAccountId" required><br>
        <label>Receiver Account ID: </label><input type="number" name="receiverAccountId" required><br>
        <label>Amount: </label><input type="number" step="0.01" name="amount" required><br>
        <label>Description: </label><input type="text" name="description" required><br>
        <input type="submit" value="Transfer">
    </form>
</body>
</html>
