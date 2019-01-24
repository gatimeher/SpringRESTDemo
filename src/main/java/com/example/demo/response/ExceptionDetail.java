package com.example.demo.response;

import java.util.Date;

public class ExceptionDetail {

    private Date timestamp;
    private String message;
    private String details;

    public ExceptionDetail(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
