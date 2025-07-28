package com.jks.springbootrest1.exception;

import com.jks.springbootrest1.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNPE(RuntimeException ex, WebRequest webRequest){
        return this.handleExceptionInternal(ex,new ErrorResponse(ex.getMessage(), LocalDateTime.now()),new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,webRequest);
    }
}
