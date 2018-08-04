package com.cjf.demo;

import com.opensymphony.xwork2.ActionSupport;

public class DemoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		 
		System.out.println("Hello! Action");
		
		return SUCCESS;
	}

	
	
}
