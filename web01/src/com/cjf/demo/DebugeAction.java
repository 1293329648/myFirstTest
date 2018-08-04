package com.cjf.demo;

import com.opensymphony.xwork2.ActionSupport;

public class DebugeAction extends ActionSupport{


	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		 
		System.out.println("this is test");
	  
		return SUCCESS;
	}
	public String add() {
		System.out.println("add......");
		return SUCCESS;
	}
	public String del() {
		System.out.println("del......");
		return SUCCESS;
	}
	
	

}
