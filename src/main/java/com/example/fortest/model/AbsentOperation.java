package com.example.fortest.model;

import com.example.fortest.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbsentOperation {
    Connection connection;
    PreparedStatement preparedStatement;

    public String absent(int userid,String content,String date){
        try {
            connection = DBConnection.getMySQLConnection();
            System.out.println(userid);
            System.out.println(content);
            System.out.println(date);

            preparedStatement = connection.prepareStatement("INSERT INTO Absent_Form(user_id,abs_info,abs_date,abs_status) VALUES (?,?,?,?)");
            preparedStatement.setInt(1,userid);
            preparedStatement.setString(2,content);
            preparedStatement.setString(3,date);
            preparedStatement.setInt(4,0);

            preparedStatement.execute();
            return "Success";

        } catch (Exception e) {
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
