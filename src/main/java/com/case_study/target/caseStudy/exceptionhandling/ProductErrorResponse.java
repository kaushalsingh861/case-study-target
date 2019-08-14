package com.case_study.target.caseStudy.exceptionhandling;

public class ProductErrorResponse {
	
	int status;
	String message;
	
	
	
	public ProductErrorResponse() {
		
	}
	
	public ProductErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
