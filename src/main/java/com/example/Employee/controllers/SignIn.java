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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="SignIn", value = "/SignIn")
@MultipartConfig
public class SignIn extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();//แปลงเป็น string
        resp.setContentType("application/json");
        Middleware.setCORS(req,resp);
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if(username==null || password==null){
                ErrorResponse errorResponse = new ErrorResponse("missing username or password", 400);
                resp.setStatus(400);
                out.print(gson.toJson(errorResponse));
                return;
            }
            User user = new UserOperation().signInUser(username,password);
            if(username==null ){
                ErrorResponse errorResponse = new ErrorResponse("werong username or password", 400);
                resp.setStatus(400);
                out.print(gson.toJson(errorResponse));
                return;
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("userid",user.getId());
            resp.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
