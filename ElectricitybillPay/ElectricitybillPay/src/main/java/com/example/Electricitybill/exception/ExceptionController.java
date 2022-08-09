package com.example.Electricitybill.exception;


import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController  {
	@ExceptionHandler(value= NoSuchCustomerException.class)
	public ResponseEntity<Object> exception(NoSuchCustomerException exception){
		
		return new ResponseEntity<Object>("Customer not found",HttpStatus.NOT_FOUND);
	}
	
	
	
		
}