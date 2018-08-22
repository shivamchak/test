<%--
  Created by IntelliJ IDEA.
  User: shivam
  Date: 22/8/18
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Subjects</title>
</head>
<body>

        <h2>Please Fill All fields</h2>
                    <form action="/updateStudent" method="get">
                        Enter student Subjects&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="studentSubjects" required/><br><br>
                        <input type="submit" value="Update Subjects"/>
                    </form>


</body>
</html>
