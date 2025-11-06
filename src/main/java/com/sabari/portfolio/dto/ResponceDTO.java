package com.sabari.portfolio.dto;

public class ResponceDTO {
	private boolean status;
	private String message;
	private Object returnObject;

	public ResponceDTO() {
		// TODO Auto-generated constructor stub
	}

	public ResponceDTO(boolean status, String message) {
		this.status = status;
		this.message = message;
	}

	public ResponceDTO(boolean status, String message, Object returnObject) {
		this.status = status;
		this.message = message;
		this.returnObject = returnObject;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

}
