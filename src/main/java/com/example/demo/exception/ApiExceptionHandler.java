package com.example.demo.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value= {ApiRequestException.class})
	public ResponseEntity<Object> handleApiExceptionHandler(ApiRequestException e){
		//1. create payload containing exception and detail
		ApiException apiException = new ApiException(e.getMessage(), e.getCause(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
		
		//2. return response Entity
		return new ResponseEntity<Object>(apiException, HttpStatus.BAD_REQUEST);
	}

}
