package com.project.ShortenerUrl.service.exception;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ApiException extends RuntimeException {
    private final String error;
    private final String message;
    private final Integer status;
    private final LocalDateTime timestamp;

    public ApiException(String error, String message, Integer status) {
        super(message);
        this.error = error;
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
