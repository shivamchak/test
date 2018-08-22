<%--
  Created by IntelliJ IDEA.
  User: shivam
  Date: 21/8/18
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>
<h2 align="center">* Please Enter Roll Number to delete student *</h2>
<form action="/deleteStudent" method="get">
    Enter student roll number to delete Student: <input type="text" name="studentRollNumber" required/><br><br>
<input type="submit" name="submit" value="Delete Student"/>
</form>
</body>
</html>
