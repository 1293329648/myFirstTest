package com.cjf.demo;

import com.cjf.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport implements ModelDriven<User> {
   
   	private static final long serialVersionUID = 1L;
	User user =new User();
	
	  
	             
	     

	public String execute() throws Exception {
		
		   ValueStack valueStack = ActionContext.getContext().getValueStack();
		   
		   valueStack.push(user);
		   
		   System.out.println(user);
	
		return  SUCCESS;
	}







	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
	
}
