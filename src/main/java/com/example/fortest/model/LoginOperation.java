package com.example.fortest.model;

import com.example.fortest.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginOperation {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Login login;
    public Login checkLogin (String username, String password) {
        try {
            connection = DBConnection.getMySQLConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE username=? AND password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                login = new Login(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
}