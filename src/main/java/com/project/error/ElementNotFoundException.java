package com.project.error;

@SuppressWarnings("serial")
public class ElementNotFoundException extends Exception {
	private String message ; 
	public ElementNotFoundException(String message){
		super(message); 
		this.message = message ; 
	}
	@Override
	public String getMessage() {
		 return this.message ; 
	}
}
