package com.project.ShortenerUrl.service.exception;

import java.time.LocalDateTime;

public class ApiError {
    private String error;
    private String message;
    private Integer status;
    private LocalDateTime timestamp;

    public ApiError() {
    }

    public ApiError(String error, String message, Integer status, LocalDateTime timestamp) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
