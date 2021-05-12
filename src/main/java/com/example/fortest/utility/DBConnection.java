package com.example.fortest.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String db_URL = "jdbc:mysql://csproject.sit.kmutt.ac.th:3306/db63130500210";
    public static Connection getMySQLConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_URL,"63130500210","abcd1234");
            System.out.println("success");
            return connection;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
