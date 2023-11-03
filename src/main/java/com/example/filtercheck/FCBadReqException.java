package com.example.filtercheck;

public class FCBadReqException extends RuntimeException{
	public FCBadReqException(String msg) {
		super(msg);
		System.out.println("FCBadReqException : called");
		
	}
}
