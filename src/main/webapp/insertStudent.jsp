<%--
  Created by IntelliJ IDEA.
  User: shivam
  Date: 21/8/18
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Student</title>
</head>
<body>
<h2 align="center">* Please Enter all Data to insert student *</h2>
<form action="/insertStudent" method="get">
    Enter Student Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="studentName" required/><br><br>
    Enter Student Last Name&nbsp;<input type="text" name="studentLastName" required/><br><br>
    Enter Student Class&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="studentClass" required/><br><br>
    Enter Student Subjects&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="studentSubjects" required/><br><br><br>
    <input type="submit" name="submit" value="Insert Data"/>
</form>
</body>
</html>
