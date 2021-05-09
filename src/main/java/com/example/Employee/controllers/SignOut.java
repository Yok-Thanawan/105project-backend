package com.example.Employee.controllers;

import com.example.Employee.models.Middleware;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="SignOut", value = "/SignOut")
@MultipartConfig
public class SignOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Middleware.setCORS(req,resp);
        if(session!=null){
            session.invalidate();
        }
        resp.setStatus(200);
    }
}
