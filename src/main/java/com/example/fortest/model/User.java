package com.example.fortest.model;

import java.sql.ResultSet;

public class User {
    int userid;
    String fullname;
    String username;
    String password;
    String email;
    String address;
    String tel;
    String birthdate;
    String empdate;
    double salary;
    String role;

    public User(int userid, String fullname, String username, String password, String email, String address, String tel, String birthdate, String empdate, double salary, String role) {
        this.userid = userid;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.birthdate = birthdate;
        this.empdate = empdate;
        this.salary = salary;
        this.role = role;
    }

    public User(ResultSet resultSet) throws Exception{
        this.userid = resultSet.getInt("user_id");
        this.fullname = resultSet.getString("fullname");
        this.username = resultSet.getString("username");
        this.password = resultSet.getString("password");
        this.email = resultSet.getString("email");
        this.address = resultSet.getString("address");
        this.tel = resultSet.getString("tel");
        this.birthdate = resultSet.getString("birthdate");
        this.empdate = resultSet.getString("empdate");
        this.salary = resultSet.getDouble("salary");
        this.role = resultSet.getString("role");
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getEmpdate() {
        return empdate;
    }

    public void setEmpdate(String empdate) {
        this.empdate = empdate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
