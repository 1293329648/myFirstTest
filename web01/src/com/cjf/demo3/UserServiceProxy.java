package com.cjf.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxy  implements  InvocationHandler{
   
	User1Service us;
	public UserServiceProxy(User1Service us) {	  
		super();
		this.us=us;		
	}
	
	public User1Service  getProxyUserService() {
		 User1Service usproxy=(User1Service) Proxy.newProxyInstance(UserServiceProxy.class.getClassLoader(),
				    User1ServiceImpl.class.getInterfaces() ,
				     this);
		return usproxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	       System.out.println("开启事务！");
		  Object invoke = method.invoke(us, args);
		  System.out.println("提交事务！");
		  return   invoke;
	}
	
	
}
