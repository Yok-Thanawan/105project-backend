package com.example.fortest.controller;

import com.example.fortest.model.ErrorResponse;
import com.example.fortest.model.FindbyUserid;
import com.example.fortest.model.User;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", value = "/ProfileServlet")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Middleware.setCORS(request,response);
        Gson gson = new Gson();
        response.setContentType("application/json");
        try(PrintWriter out = response.getWriter()) {
            int userid = Middleware.authCheck(request, response);
            FindbyUserid findbyUserid = new FindbyUserid();
            User finduser = findbyUserid.findbyUserid(userid);
            out.print(gson.toJson(finduser));

        }catch (Exception e) {
            e.printStackTrace();
            ErrorResponse errorResponse = new ErrorResponse(e.toString(), 500);
            response.setStatus(500);

        } catch (ErrorResponse errorResponse) {
            errorResponse.printStackTrace();
        }
    }


}
