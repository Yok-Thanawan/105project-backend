package com.example.Employee.controllers;

import com.example.Employee.models.ErrorResponse;
import com.example.Employee.models.Middleware;
import com.example.Employee.models.User;
import com.example.Employee.models.UserOperation;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="SignUp", value = "/SignUp")
@MultipartConfig
public class SignUp extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();//แปลงเป็น string
        resp.setContentType("application/json");
        Middleware.setCORS(req,resp);
        try{
            String email = req.getParameter("email");
            String fullname = req.getParameter("fullname");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String address = req.getParameter("address");
            String tel = req.getParameter("tel");
            String birthdate = req.getParameter("birthdate");
            if(username==null || password==null){
                ErrorResponse errorResponse = new ErrorResponse("missing username or password", 400);
                resp.setStatus(400);
                out.print(gson.toJson(errorResponse));
                return;
            }
            UserOperation userOperation = new UserOperation();
            User existUser = userOperation.getUser(username);
            if(existUser!=null){
                ErrorResponse errorResponse = new ErrorResponse("username is already used", 400);
                resp.setStatus(400);
                out.print(gson.toJson(errorResponse));
                return;
            }
            User user= userOperation.innerUser(email, fullname, username, password, address, tel, birthdate);
            out.print(gson.toJson(user));
            resp.setStatus(201);
            req.getSession(true);
        }catch (Exception e){
            e.printStackTrace();
            ErrorResponse errorResponse = new ErrorResponse(e.toString(), 500);
            resp.setStatus(500);
            out.print(gson.toJson(errorResponse));
        }
    }
}
