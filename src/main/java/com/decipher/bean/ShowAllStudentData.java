package com.decipher.bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ShowAllStudentData")
public class ShowAllStudentData extends HttpServlet {
    Connection connection;
    Statement statement;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        connection = DatabaseConfiguration.getConnection();
        try {
            statement = connection.createStatement();
            String getAllStudentQuery = "select * from studentRecords";
            ResultSet resultSet = statement.executeQuery(getAllStudentQuery);
            if(resultSet!=null){
                while (resultSet.next()){

                    int studentRollNumber = resultSet.getInt(1);
                    String studentName = resultSet.getString(2);
                    String studentLastName = resultSet.getString(3);
                    int studentClass = resultSet.getInt(4);
                    String studentSubjects = resultSet.getString(5);
                    response.setContentType("text/html");
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("studentRollNumber",studentRollNumber);
                    printWriter.println("Student Rollno:"+ studentRollNumber);
                    printWriter.print("<br>Student Name:"+ studentName+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printWriter.println("<a href='updateStudentName.jsp'> Update Name</a>");
                    printWriter.println("<br>Student Last Name:"+ studentLastName+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printWriter.println("<a href='updateStudentLastName.jsp'> Update Last Name</a>");
                    printWriter.println("<br>Student Student Class:"+ studentClass+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printWriter.println("<a href='updateStudentClass.jsp'> Update Class</a>");
                    printWriter.println("<br>Student Subjects:"+ studentSubjects+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    printWriter.println("<a href='updateStudentSubjects.jsp'> Update Subjects</a>");
                    printWriter.println();

                    printWriter.println("<br><br><a href='/deleteStudent'> Delete Student</a><br><br><br>");

                    printWriter.print("\n\n");
                }
                connection.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //printWriter.println("Hello Welcome to my Student Panel");
    }


}
