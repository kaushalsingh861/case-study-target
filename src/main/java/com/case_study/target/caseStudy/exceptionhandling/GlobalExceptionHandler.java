package com.case_study.target.caseStudy.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleException(ProductException pe){
		ProductErrorResponse per = new ProductErrorResponse();
		per.setMessage(pe.getMessage());
		per.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(per,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleException(Exception e){
		ProductErrorResponse per =  new ProductErrorResponse();
		per.setMessage("Bad Request");
		per.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(per,HttpStatus.BAD_REQUEST);

	}
}
