package com.example.demo.response;

public class Status {

    private String statusCode;
    private String statusMessage;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Status{");
        sb.append("statusCode='").append(statusCode).append('\'');
        sb.append(", statusMessage='").append(statusMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
