package com.decipher.bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "UpdateStudent")
public class UpdateStudent extends HttpServlet {
    private Connection connection;
    private Statement statement;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        try {
          HttpSession httpSession = request.getSession();
            int studentRollNumber = (int) httpSession.getAttribute("studentRollNumber");
            String studentName = request.getParameter("studentName");
            String studentLastName = request.getParameter("studentLastName");
            String studentClass = request.getParameter("studentClass");
            String studentSubjects = request.getParameter("studentSubjects");
            response.setContentType("text/html");

            if (studentName != null) {
                connection = DatabaseConfiguration.getConnection();
                statement = connection.createStatement();
                String updateNameQuery = "update studentRecords set studentName = ? where studentRollNumber = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateNameQuery);
                preparedStatement.setString(1, studentName);
                preparedStatement.setInt(2, studentRollNumber);
                int checkQuery = preparedStatement.executeUpdate();

                if (checkQuery > 0) {
                    printWriter.println("Student Name Successfully Updated");
                    printWriter.println("<a href='index.jsp'><h2>Back to home</h2></a>");
                } else {
                    printWriter.println("Problem in Updating please check roll no and try again!!!");
                }

            }
            if (studentLastName != null) {
                connection = DatabaseConfiguration.getConnection();
                statement = connection.createStatement();
                String updateNameQuery = "update studentRecords set studentLastName = ? where studentRollNumber = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateNameQuery);
                preparedStatement.setString(1, studentLastName);
                preparedStatement.setInt(2, studentRollNumber);
                int checkQuery = preparedStatement.executeUpdate();
                if (checkQuery > 0) {
                    printWriter.println("Student Last Name Successfully Updated");
                    printWriter.println("<a href='index.jsp'><h2>Back to home</h2></a>");
                } else {
                    printWriter.println("Problem in Updating please check roll no and try again!!!");
                }
            }
            if (studentClass != null) {
                connection = DatabaseConfiguration.getConnection();
                statement = connection.createStatement();
                String updateClassQuery = "update studentRecords set studentClass = ? where studentRollNumber = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateClassQuery);
                preparedStatement.setString(1, studentClass);
                preparedStatement.setInt(2, studentRollNumber);
                int checkQuery = preparedStatement.executeUpdate();
                if (checkQuery > 0) {
                    printWriter.println("Student Class Successfully Updated");
                    printWriter.println("<a href='index.jsp'><h2>Back to home</h2></a>");
                } else {
                    printWriter.println("Problem in Updating please check roll no and try again!!!");
                }
            }
            if (studentSubjects != null) {
                connection = DatabaseConfiguration.getConnection();
                statement = connection.createStatement();
                String updateSubjectQuery = "update studentRecords set studentSubjects = ? where studentRollNumber = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateSubjectQuery);
                preparedStatement.setString(1, studentSubjects);
                preparedStatement.setInt(2, studentRollNumber);
                int checkQuery = preparedStatement.executeUpdate();
                if (checkQuery > 0) {
                    printWriter.println("Student Subjects Successfully Updated");
                    printWriter.println("<a href='index.jsp'><h2>Back to home</h2></a>");
                } else {
                    printWriter.println("Problem in Updating please check roll no and try again!!!");
                }
            } else {
                    System.out.println("Please select valid option to continue");
                }
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
