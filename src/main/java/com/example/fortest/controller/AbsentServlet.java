package com.example.fortest.controller;

import com.example.fortest.model.AbsentOperation;
import com.example.fortest.model.ErrorResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AbsentServlet", value = "/AbsentServlet")
@MultipartConfig
public class AbsentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware.setCORS(request, response);
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");

            int userid = Middleware.authCheck(request, response);
            String date = request.getParameter("date");
            String content = request.getParameter("content");
            AbsentOperation absentOperation = new AbsentOperation();
            String form = absentOperation.absent(userid, content, date);
            if(form.equals("Fail")){
                response.setStatus(400);
            }
            if(form.equals("Success")) {
                response.setStatus(201);
            }
        } catch (ErrorResponse errorResponse) {
            errorResponse.printStackTrace();
        }
    }
}