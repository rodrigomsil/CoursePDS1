package com.iftm.PDS1.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id){
		super("Resource not found. ID " +id);
	}
}
