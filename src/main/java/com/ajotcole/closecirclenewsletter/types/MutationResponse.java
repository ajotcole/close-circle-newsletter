package com.ajotcole.closecirclenewsletter.types;

public class MutationResponse {
    Integer statusCode;
    String message;

    public MutationResponse (Integer statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public MutationResponse() { super();}
    public Integer getStatusCode() { return statusCode;}
    public void setStatusCode(Integer statusCode) {this.statusCode = statusCode;}
    public String getMessage() { return message;}
    public void setMessage(String message) {this.message = message;}
}
