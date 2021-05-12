package com.example.fortest.model;

import java.sql.ResultSet;

public class Register {
    String fullname;
    String email;
    String address;
    String tel;
    String birthdate;
    String username;
    String password;

    public Register(String fullname, String email, String address, String tel, String birthdate, String username, String password) {
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.birthdate = birthdate;
        this.username = username;
        this.password = password;
    }

    public Register(ResultSet resultSet) throws Exception {
        this.fullname = resultSet.getString("fullname");
        this.email = resultSet.getString("email");
        this.address = resultSet.getString("address");
        this.tel = resultSet.getString("tel");
        this.birthdate = resultSet.getString("birthdate");
        this.username = resultSet.getString("username");
        this.password = resultSet.getString("password");
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
