<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Form</title>
</head>
<body>

    <h2>Welcome Our  Bank Services</h2>

    <form action="createAccount" method="post">
        <!-- Hidden field for customerId -->
        <input type="hidden" name="customerId" value="${customer.customerId}" />

        <!-- Customer Name -->
        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" value="${customer.customerName}" required /><br/>

        <!-- Customer Address -->
        <label for="customerAddress">Customer Address:</label>
        <input type="text" id="customerAddress" name="customerAddress" value="${customer.customerAddress}" required /><br/>

        <!-- Customer Pan No -->
        <label for="customerPanNo">Customer PAN No:</label>
        <input type="text" id="customerPanNo" name="customerPanNo" value="${customer.customerPanNo}" required /><br/>

        <!-- Customer Aadhar No -->
        <label for="customerAdharNo">Customer Aadhar No:</label>
        <input type="text" id="customerAdharNo" name="customerAdharNo" value="${customer.customerAdharNo}" required /><br/>

        <!-- Customer Phone -->
        <label for="customerPhone">Customer Phone:</label>
        <input type="text" id="customerPhone" name="customerPhone" value="${customer.customerPhone}" required /><br/>

        <!-- Customer Email -->
        <label for="customerEmail">Customer Email:</label>
        <input type="email" id="customerEmail" name="customerEmail" value="${customer.customerEmail}" required /><br/>

        <!-- Customer Date of Birth -->
        <label for="customerDateOfBirth">Date of Birth:</label>
        <input type="date" id="customerDateOfBirth" name="customerDateOfBirth" value="${customer.customerDateOfBirth}" required /><br/>

        <!-- Customer Nationality -->
        <label for="customerNationality">Nationality:</label>
        <select id="customerNationality" name="customerNationality" required>
            <option value="India" ${customer.customerNationality == 'India' ? 'selected' : ''}>India</option>
            <option value="United States" ${customer.customerNationality == 'United States' ? 'selected' : ''}>United States</option>
            <option value="United Kingdom" ${customer.customerNationality == 'United Kingdom' ? 'selected' : ''}>United Kingdom</option>
            <option value="Canada" ${customer.customerNationality == 'Canada' ? 'selected' : ''}>Canada</option>
            <option value="Australia" ${customer.customerNationality == 'Australia' ? 'selected' : ''}>Australia</option>
            <option value="Germany" ${customer.customerNationality == 'Germany' ? 'selected' : ''}>Germany</option>
            <option value="France" ${customer.customerNationality == 'France' ? 'selected' : ''}>France</option>
            <option value="China" ${customer.customerNationality == 'China' ? 'selected' : ''}>China</option>
            <option value="Japan" ${customer.customerNationality == 'Japan' ? 'selected' : ''}>Japan</option>
            <option value="Brazil" ${customer.customerNationality == 'Brazil' ? 'selected' : ''}>Brazil</option>
            <option value="South Africa" ${customer.customerNationality == 'South Africa' ? 'selected' : ''}>South Africa</option>
            <!-- Add more countries as needed -->
        </select><br/>

        <!-- Customer Gender -->
        <label for="customerGender">Gender:</label>
        <select id="customerGender" name="customerGender" required>
            <option value="Male" ${customer.customerGender == 'Male' ? 'selected' : ''}>Male</option>
            <option value="Female" ${customer.customerGender == 'Female' ? 'selected' : ''}>Female</option>
            <option value="Other" ${customer.customerGender == 'Other' ? 'selected' : ''}>Other</option>
        </select><br/>

        <!-- Account Detail Section (optional, can be expanded as per your requirement) -->
        <h3>Account Detail</h3>
        <label for="accountDetail">Account Detail:</label>
        <input type="text" id="accountDetail" name="accountDetail" value="${customer.accountDetail}" readonly/><br/>

        <!-- Submit button -->
        <input type="submit" value="Submit"/>
    </form>

</body>
</html>
