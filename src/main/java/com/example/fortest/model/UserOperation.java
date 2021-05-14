package com.example.fortest.model;

import com.example.fortest.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserOperation {
    Connection connection;
    PreparedStatement preparedStatement;
    public String updateUser(int userid,String fullname, String email, String address, String tel, String birthdate, String username, String password) throws Exception{
        boolean result = false;
        try{
            connection = DBConnection.getMySQLConnection();
            preparedStatement = connection.prepareStatement("UPDATE User SET  fullname = ?,email = ?, address = ?, tel = ?, birthdate = ?, username = ?, password = ? WHERE user_id = ? ");
            preparedStatement.setString(1,fullname);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,tel);
            preparedStatement.setString(5,birthdate);
            preparedStatement.setString(6,username);
            preparedStatement.setString(7,password);
            preparedStatement.setInt(8,userid);

            preparedStatement.executeUpdate();
            return "success";

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "fail";
    }
}
