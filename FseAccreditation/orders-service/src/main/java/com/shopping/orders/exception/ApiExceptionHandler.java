package com.shopping.orders.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {CustomException.class})
	public ResponseEntity<ExceptionData> customeExceptionHandling(CustomException e)
	{
		ExceptionData exceptionData=new ExceptionData(e.getMessage(),LocalDateTime.now(),e);
		
		return new ResponseEntity<>(exceptionData,HttpStatus.NOT_FOUND);
	}


}
