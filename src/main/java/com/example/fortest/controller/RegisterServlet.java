package com.example.fortest.controller;

import com.example.fortest.model.RegisterOperation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware.setCORS(request,response);
        try(PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            RegisterOperation registerOperation = new RegisterOperation();
            HttpSession session = request.getSession(false);

            String signup = registerOperation.register(request.getParameter("fullname"), request.getParameter("email"), request.getParameter("address"), request.getParameter("tel"), request.getParameter("birthdate"), request.getParameter("username"), request.getParameter("password"));

            if (signup.equals("Failed")) {
                response.setStatus(400);
                getServletContext().getRequestDispatcher("/").forward(request, response);
                out.println("FAILED REGISTER");
            } else {
                out.print("success");
                response.setStatus(201);
                request.getSession(true);
            }
        }
    }
}
