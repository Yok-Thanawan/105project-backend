package com.example.fortest.controller;

import com.example.fortest.model.ErrorResponse;
import com.example.fortest.model.UserOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", value = "/UpdateProfileServlet")
@MultipartConfig
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware.setCORS(request, response);
        try {
            response.setContentType("text/html;charset=UTF-8");
            int userid = Middleware.authCheck(request,response);
            UserOperation userOperation = new UserOperation();
            String update = userOperation.updateUser(userid,request.getParameter("fullname"), request.getParameter("email"), request.getParameter("address"), request.getParameter("tel"), request.getParameter("birthdate"), request.getParameter("username"), request.getParameter("password"));
            if(update.equals("fail")){
                response.setStatus(400);
            }
            if(update.equals("success")){
                response.setStatus(201);
            }
        } catch (ErrorResponse | Exception errorResponse) {
            errorResponse.printStackTrace();
        }
    }
}
