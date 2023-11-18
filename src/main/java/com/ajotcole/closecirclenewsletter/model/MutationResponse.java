package com.ajotcole.closecirclenewsletter.model;

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

    public static class Builder {

        private final MutationResponse mutationResponse = new MutationResponse();

        public Builder setStatusCode(Integer statusCode) {
            mutationResponse.statusCode = statusCode;
            return this;
        }

        public Builder setMessage(String message) {
            mutationResponse.message = message;
            return this;
        }

        public MutationResponse build() {
            return mutationResponse;
        }
    }
}
