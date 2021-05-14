package com.example.fortest.model;

import com.example.fortest.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AttendanceOperation {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    public String attendance(int userid, String passcode){
        try {
            connection = DBConnection.getMySQLConnection();

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();

            preparedStatement = connection.prepareStatement("SELECT * FROM AttendanceCode WHERE code=? AND date=?");
            preparedStatement.setString(1,passcode);
            preparedStatement.setString(2,dtf.format(now));
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                preparedStatement = connection.prepareStatement("INSERT INTO Attendance(user_id,status,date) VALUES (?,?,?)");
                preparedStatement.setInt(1, userid);
                preparedStatement.setInt(2, 1);
                preparedStatement.setString(3, dtf.format(now));

                preparedStatement.execute();
                return "Success";
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "Fail";
    }
}
