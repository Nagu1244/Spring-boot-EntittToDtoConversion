package com.springboot.globalException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.springboot.exception.ErrorDetails;
import com.springboot.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<ErrorDetails> handleException(ResourceNotFoundException ex,WebRequest request)
	{
		ErrorDetails exceptionDetails=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(exceptionDetails,HttpStatus.NOT_FOUND);
	}
}
