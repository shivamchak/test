package com.decipher.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private final static String URL = "jdbc:mysql://localhost:3306/records";
    private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "root";
    private static Connection connection;

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("failed to create database connection");
            e.printStackTrace();
        }
        return connection;
    }

}
