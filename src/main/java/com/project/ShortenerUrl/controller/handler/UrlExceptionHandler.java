package com.project.ShortenerUrl.controller.handler;

import com.project.ShortenerUrl.service.exception.ApiError;
import com.project.ShortenerUrl.service.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class UrlExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(UrlExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> ApiException(ApiException exception){
        logger.error("New Api error occurred, caused by '{}', stacktrace '{}'",exception.getMessage(), exception.getStackTrace());

        ApiError apiError = new ApiError(exception.getError(),
                exception.getMessage(), exception.getStatus(), exception.getTimestamp());

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> Exception(Exception e) {
        logger.error("Internal Server error occurred, see the stracktrace '{}'",  e.getStackTrace());

        ApiError apiError = new ApiError("internal_server_error", "the internal server error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());

       return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
