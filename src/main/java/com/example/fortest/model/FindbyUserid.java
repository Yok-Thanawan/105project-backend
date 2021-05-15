package com.example.fortest.model;

import com.example.fortest.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FindbyUserid {
    public User findbyUserid (int userId){
        User user = null;
        try{
            Connection connection = DBConnection.getMySQLConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE user_id = ? ");
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            user = new User(resultSet);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
