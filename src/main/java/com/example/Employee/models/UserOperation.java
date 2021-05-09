package com.example.Employee.models;

import com.example.Employee.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOperation  {
    Connection connection;
    public User innerUser(String email, String fullname, String username, String password,String address, String tel, String birthdate) throws SQLException {
        try{
            connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO User(email,fullname,username,password,address,tel,birthdate) VALUES  (?,?,?,?,?,?,?)");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,fullname);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,address);
            preparedStatement.setString(6,tel);
            preparedStatement.setString(7,birthdate);
            preparedStatement.execute();
            return this.getUser(username);
        }
        finally{
            connection.close();
        }
    }
    public User getUser(String username) throws SQLException{
        try {
            connection =  DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE username = ? ");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user =null;
            if(resultSet.next()){
                user = new User(resultSet);
            }
            return user;
        }finally{
            connection.close();
        }
    }
    public User signInUser(String username, String password) throws SQLException{
        try {
            connection =  DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE username = ? AND password = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user =null;
            if(resultSet.next()){
                user = new User(resultSet);
            }
            return user;
        }finally{
            connection.close();
        }
    }
}
