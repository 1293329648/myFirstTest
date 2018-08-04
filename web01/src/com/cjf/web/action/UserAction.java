package com.cjf.web.action;


import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cjf.domain.User;
import com.cjf.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

 private static final long serialVersionUID = 1L;
    User user=new User();
    UserService userService;	


	public String login() throws Exception {
        ServletContext sc = ServletActionContext.getServletContext();
        //从sc中获得wac容器
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        UserService userService=(UserService)wac.getBean("userService");
        
	   User u =  userService.login(user);	   
	   ActionContext.getContext().getSession().put("user", u);		
		return "toHome";
	}
	
	@Override
	public User getModel() {
		return user;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
