package com.example.userservice.exception;

import com.example.userservice.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {


     @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Error> handleUserAlreadyExistsException(final UserAlreadyExistsException exception){
        Error error= new Error(exception.getMessage(), Instant.now());
        // you can use 409(CONFLICT) or 400(BAD REQUEST) here, that's the other debate on this
        // for simplicity, I am using 400 (BAD_REQUEST)
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<Error> handleUserServiceException(final UserServiceException userServiceException){
         Error error= new Error(userServiceException.getMessage(), Instant.now());
         return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }


}
