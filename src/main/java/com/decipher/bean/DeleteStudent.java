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

@WebServlet(name = "DeleteStudent")
public class DeleteStudent extends HttpServlet {
    private Connection connection;
    private Statement statement;

       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           PrintWriter printWriter = response.getWriter();
           connection = DatabaseConfiguration.getConnection();
//           String studentRollno = request.getParameter("studentRollNumber");

           try {
                HttpSession httpSession = request.getSession();
                int studentRollno = (int) httpSession.getAttribute("studentRollNumber");

               statement = connection.createStatement();
               String studentDeleteQuery = "delete from studentRecords WHERE studentRollNumber='"+studentRollno+"'";
              int countQuery= statement.executeUpdate(studentDeleteQuery);
              if(countQuery>0){
                  response.setContentType("text/html");
                  printWriter.println("Student Delete Successfully !!!");
                  printWriter.println("<a href='index.jsp'><h2>Back to home</h2></a>");


              }else{
                  printWriter.println("Problem in deleting student please Chek the rollno and try again");
              }

              connection.close();


           } catch (SQLException e) {
               e.printStackTrace();

           }

       }
}
