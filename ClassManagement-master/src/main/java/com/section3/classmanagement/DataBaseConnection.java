package com.section3.classmanagement;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

public class DataBaseConnection {
    private Connection databaseLink;

    DataBaseConnection() throws SQLException, ClassNotFoundException{
        String databaseName = "new";
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost/" + databaseName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
    }
    public Boolean login(TextField userName, PasswordField passWord) throws SQLException, ClassNotFoundException {
        String username = userName.getText();
        String password = passWord.getText();
        String checkStatement = "select * from school2 where `User name` = \"" + username + "\" and password = " + password;
        Statement statement = databaseLink.createStatement();
        ResultSet result = statement.executeQuery(checkStatement);
        return result.next();
    }

//        resultSet = statement.executeQuery("select * from teacher;");
//
//        while(resultSet.next()) {
//            String name = resultSet.getString("username");
//            int password = resultSet.getInt("password");
//
//            System.out.println("Name: " + name);
//            System.out.println("Password: " + password);
//
}

