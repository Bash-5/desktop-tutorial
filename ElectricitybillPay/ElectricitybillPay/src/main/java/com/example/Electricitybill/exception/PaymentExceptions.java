package com.example.Electricitybill.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentExceptions {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArguement(MethodArgumentNotValidException ex){
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		
		return errorMap;
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void constraintViolationException(HttpServletResponse response)throws IOException{
		response.sendError(HttpStatus.BAD_REQUEST.value());;
		
	}
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public void unexpectedTypeException(HttpServletResponse response) throws IOException{
    response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
