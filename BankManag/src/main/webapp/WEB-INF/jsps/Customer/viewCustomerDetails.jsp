<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<!DOCTYPE html>
<html>
<head>
    <title>Customer Details</title>
</head>
<body>
    <h1>Customer Details</h1>
    <c:if test="${customer != null}">
        <p>Name: ${customer.customerName}</p>
        <p>Email: ${customer.customerEmail}</p>
        <p>Phone: ${customer.customerPhone}</p>
        <p>Balance: ${customer.balance}</p>
    </c:if>
    <c:forEach var="viewCustomerDetails" items="${viewCustomerDetails}">
    <c:if test="${customers != null}">
        <h2>Customer List</h2>
        <c:forEach var="cust" items="${customers}">
            <p>Name: ${cust.customerName}</p>
            <p>Email: ${cust.customerEmail}</p>
            <p>Phone: ${cust.customerPhone}</p>
            <p>Balance: ${cust.balance}</p>
            <hr>
        </c:forEach>
    </c:if>
    </c:forEach>
</body>
</html>
