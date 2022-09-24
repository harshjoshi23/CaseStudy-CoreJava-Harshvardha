package com.project.error;

@SuppressWarnings("serial")
public class FormatNotCorrect extends Exception {
	private String message ; 
	public FormatNotCorrect(String message){
		super(message); 
		this.message = message ; 
	}
	@Override
	public String getMessage() {
		 return this.message ; 
	}
}

