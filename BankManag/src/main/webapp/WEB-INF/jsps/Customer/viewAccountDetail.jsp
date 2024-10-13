
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Account Details</title>
</head>
<body>
    <h1>View Account Details</h1>
    <form action="getAccountDetailByCustomerId" method="get">
        <label>Account ID: </label><input type="number" name="accountId" required><br>
        <input type="submit" value="View Details">
    </form>
</body>
</html>
