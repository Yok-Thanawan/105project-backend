package com.example.fortest.model;

import com.example.fortest.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterOperation {
    Connection connection;
    PreparedStatement preparedStatement;

    public String register(String fullname, String email, String address, String tel, String birthdate, String username, String password) {
        try {
            connection = DBConnection.getMySQLConnection();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();

            preparedStatement = connection.prepareStatement("INSERT INTO User(fullname,email,address,tel,birthdate,username,password,emp_date,salary,role) VALUES  (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,fullname);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,tel);
            preparedStatement.setString(5,birthdate);
            preparedStatement.setString(6,username);
            preparedStatement.setString(7,password);
            preparedStatement.setString(8,dtf.format(now));
            preparedStatement.setString(9,"0");
            preparedStatement.setString(10,"employee");

            preparedStatement.execute();
            return "Successful";

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "Failed";
    }


}
