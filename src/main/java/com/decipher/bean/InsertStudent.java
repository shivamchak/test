package com.decipher.bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "InsertStudent")
public class InsertStudent extends HttpServlet {
    private Connection connection;
    private Statement statement;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String studentName = request.getParameter("studentName");
          String studentLastName = request.getParameter("studentLastName");
          String studentClass = request.getParameter("studentClass");
          int studentClassInt = Integer.parseInt(studentClass);
          String studentSubjects = request.getParameter("studentSubjects");

          PrintWriter printWriter = response.getWriter();
          connection = DatabaseConfiguration.getConnection();
          try {
              statement = connection.createStatement();

              String insertStudentQuery = "insert into studentRecords (studentName,studentLastName,studentClass,studentSubjects) values (?,?,?,?)";
              PreparedStatement preparedStatement = connection.prepareStatement(insertStudentQuery);
              preparedStatement.setString(1,studentName);
              preparedStatement.setString(2,studentLastName);
              preparedStatement.setInt(3,studentClassInt);
              preparedStatement.setString(4,studentSubjects);
              int countQuery = preparedStatement.executeUpdate();
              if(countQuery>0){
                  response.setContentType("text/html");
                  printWriter.println("Student successfully inserted !!!");
                  printWriter.println("<a href='index.jsp'><h2>Back to home</h2></a>");
              }else{
                  printWriter.println("Problem in registering !!!");
              }
              preparedStatement.close();

          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
}

