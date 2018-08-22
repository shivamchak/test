<%--
  Created by IntelliJ IDEA.
  User: shivam
  Date: 22/8/18
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student Last Name</title>
</head>
<body>
<h2>Please Fill All fields</h2>
<form action="/updateStudent" method="get">
    Enter student last name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="studentLastName" required/><br><br>
    <input type="submit" value="Update Last Name"/>
</form>

</body>
</html>
