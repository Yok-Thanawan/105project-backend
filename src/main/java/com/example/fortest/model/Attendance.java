package com.example.fortest.model;

import java.sql.ResultSet;

public class Attendance {
    int userid;
    String passcode;
    String date;

    public Attendance(int userid, String passcode, String date) {
        this.userid = userid;
        this.passcode = passcode;
        this.date = date;
    }

    public Attendance(ResultSet resultSet) throws Exception {
        this.userid = resultSet.getInt("user_id");
        this.passcode = resultSet.getString("passcode");
        this.date = resultSet.getString("date");
    }

    public int getUserid() {
        return userid;
    }

    public void setUsername(int userid) {
        this.userid = userid;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
