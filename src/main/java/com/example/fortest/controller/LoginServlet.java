package com.example.fortest.controller;

import com.example.fortest.model.ErrorResponse;
import com.example.fortest.model.Login;
import com.example.fortest.model.LoginOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Middleware.setCORS(request,response);
        try(PrintWriter out = response.getWriter()){
            response.setContentType("text/html;charset=UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            LoginOperation loginOperation = new LoginOperation();
            Login login = loginOperation.checkLogin(username, password);
            HttpSession session = request.getSession(true);
            session.setAttribute("userid",login.getUserid());
            response.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
