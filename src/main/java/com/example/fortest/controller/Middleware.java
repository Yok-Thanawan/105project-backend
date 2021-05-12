package com.example.fortest.controller;

import com.example.fortest.model.ErrorResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Middleware {
    public static int authCheck(HttpServletRequest request, HttpServletResponse response) throws IOException, ErrorResponse {
        HttpSession session = request.getSession(false);
        if(session==null){
            throw new ErrorResponse("unauthrized",401);
        }
        String userid = session.getAttribute("userid").toString();
        return Integer.parseInt(userid);
    }
    public static void setCORS(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET POST PUT DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Header", "*");
    }
}
