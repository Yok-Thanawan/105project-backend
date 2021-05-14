package com.example.fortest.model;

import com.example.fortest.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginOperation {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Login login=null;
    public Login checkLogin (String username, String password) {
        try {
            connection = DBConnection.getMySQLConnection();
            //check
            System.out.println("information");
            System.out.println(username);

            preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE username=? AND password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                login = new Login(resultSet);
            }return login;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
