package com.api.rest.api.model;

public class RestResponse {
	private int statuscode;
	private String messageBody;
	
	public int getStatuscode() {
		return statuscode;
	}
	public String getMessageBody() {
		return messageBody;
	}
	
	public RestResponse(int statuscode, String messageBody) {
		super();
		this.statuscode = statuscode;
		this.messageBody = messageBody;
	}
	
	@Override
	public String toString() {
		return "RestResponse [statuscode=" + statuscode + ", messageBody=" + messageBody + "]";
	}
	
	
	
	
	
	

}
