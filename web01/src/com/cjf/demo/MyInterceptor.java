package com.cjf.demo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//继承:MethodFilterInterceptor 方法过滤拦截器
//功能: 定制拦截器拦截的方法.
//	定制哪些方法需要拦截.
//	定制哪些方法不需要拦截
public class MyInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//前处理
		System.out.println("MyInterceptor 的前处理!");
		//放行
		String result = invocation.invoke();
		//后处理
		System.out.println("MyInterceptor 的后处理!");
		
		return result;
	}

}
