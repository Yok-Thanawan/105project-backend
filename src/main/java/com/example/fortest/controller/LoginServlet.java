package com.example.fortest.controller;

import com.example.fortest.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
@MultipartConfig
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware.setCORS(request,response);
        try(PrintWriter out = response.getWriter()){
            response.setContentType("text/html;charset=UTF-8");
            LoginOperation loginOperation = new LoginOperation();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Login login = loginOperation.checkLogin(username, password);

            if(username==null || password==null){
                ErrorResponse errorResponse = new ErrorResponse("wrong username or password", 400);
                response.setStatus(400);
            }
            if (login == null) {
                ErrorResponse errorResponse = new ErrorResponse("Username and/or password are not correct", 400);
                response.setStatus(400);
            }

            else {
                HttpSession session = request.getSession(true);
                session.setAttribute("userid", login.getUserid());
                response.setStatus(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
