
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Customer by Name</title>
</head>
<body>
    <h1>Search Customer by Name</h1>
    <form action="customerByName" method="get">
        <label>Customer Name: </label><input type="text" name="customerName" required><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
