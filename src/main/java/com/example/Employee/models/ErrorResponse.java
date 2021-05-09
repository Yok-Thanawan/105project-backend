package com.example.Employee.models;

public class ErrorResponse extends Throwable{
    private String error;
    private int statusCode;

    public ErrorResponse(String error,int statusCode){
        this.statusCode=statusCode;
        this.error=error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
