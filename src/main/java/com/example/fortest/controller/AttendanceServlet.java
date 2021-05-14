package com.example.fortest.controller;

import com.example.fortest.model.AttendanceOperation;
import com.example.fortest.model.ErrorResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AttendanceServlet", value = "/AttendanceServlet")
@MultipartConfig
public class AttendanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Middleware.setCORS(request,response);
        try(PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");

            int userid = Middleware.authCheck(request,response);
            String passcode = request.getParameter("passcode");
            AttendanceOperation attendanceOperation = new AttendanceOperation();

            String attend = attendanceOperation.attendance(userid,passcode);
            if(attend.equals("Fail")){
                response.setStatus(400);
            }
            if(attend.equals("Success")) {
                response.setStatus(201);

            }
        } catch (ErrorResponse errorResponse) {
            errorResponse.printStackTrace();
        }
    }
}
