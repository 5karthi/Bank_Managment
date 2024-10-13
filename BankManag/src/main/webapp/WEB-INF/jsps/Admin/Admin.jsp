<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
</head>
<body>
    <h1>Admin Home Page</h1>
    
    <form action="addAdmin" method="post">
    <pre>
        <h3>Add New Admin</h3>
        <label>Existing Admin Username: </label><input type="text" name="userName"><br>
        <label>Password: </label><input type="password" name="password"><br>
        <label>New Admin Username: </label><input type="text" name="newUserName"><br>
        <label>New Admin Password: </label><input type="password" name="newPassword"><br>
        <input type="submit" value="Add Admin">
    </form>

    <form action="updatePassword" method="post">
        <h3>Update Admin Password</h3>
        <label>Existing Admin Username: </label><input type="text" name="userName"><br>
        <label>Old Password: </label><input type="password" name="oldPassword"><br>
        <label>New Password: </label><input type="password" name="newPassword"><br>
        <input type="submit" value="Update Password">
    </form>

    <form action="deleteAdmin" method="post">
        <h3>Delete Admin</h3>
        <label>Existing Admin Username: </label><input type="text" name="userName"><br>
        <label>Password: </label><input type="password" name="password"><br>
        <input type="submit" value="Delete Admin">
        
        </pre>
    </form>

</body>
</html>
