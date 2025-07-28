package com.jks.springbootrest1.response;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private LocalDateTime timeStamp;

    public ErrorResponse(String message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
