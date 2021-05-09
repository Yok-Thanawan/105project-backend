package com.example.Employee.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String url = "jdbc:mysql://10.4.53.32:3306/db63130500210";
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("url","63130500210","abcd1234");
            return con;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
