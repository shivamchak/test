<%--
  Created by IntelliJ IDEA.
  User: shivam
  Date: 21/8/18
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
    <h2>Please Fill All fields</h2>
        <form action="/updateStudent" method="get">
            Enter student name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="studentName" required/><br><br>
            <input type="submit" value="Update Name"/>
        </form>

</body>
</html>
