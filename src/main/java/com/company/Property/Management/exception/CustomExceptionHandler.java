package com.company.Property.Management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;

//this is the central class that will handle all the exceptions- as per Aspect oriented Programming
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException){
        System.out.println("Business Exception is thrown ");
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrorModelList(), HttpStatus.BAD_REQUEST);
    }
}
