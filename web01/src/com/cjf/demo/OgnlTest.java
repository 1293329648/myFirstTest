package com.cjf.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cjf.bean.User;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;


public class OgnlTest {

	@Test
	public void Test1() {		
		User rootUser=new User("tom",18);
		Map<String,User> context = new HashMap<String,User>();
		
		context.put("user1", new User("jerry",19));
		context.put("user2", new User("rose",20));
		
		OgnlContext oContext=new OgnlContext();
		oContext.setRoot(rootUser);
		oContext.setValues(context);
		
	 try {
		String name = (String) Ognl.getValue("#user1.setName('lucy'),#user1.name",oContext,oContext.getRoot());
		                       //@类名＋类路径 @方法名（参数）  调用静态方法
		
		Double pI=(Double) Ognl.getValue("@Math@PI", oContext,oContext.getRoot());		
		System.out.println(pI);
	} catch (OgnlException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}
	
	
	@Test
	public void Test2() {
		User rootUser=new User("lisi",4);
		  Map<String,User> context=new HashMap<String,User>();
		  
		  context.put("user1", new User("wangwu", 5));
		  context.put("user2", new User("xiaosan", 3));
			
			OgnlContext oContext=new OgnlContext();
			oContext.setRoot(rootUser);
			oContext.setValues(context);
			
			
			try {
				Object value = Ognl.getValue("{'one','two','three','four'}[0]", oContext,oContext.getRoot());
				//map
				Object value2 = Ognl.getValue("#{'name':'one','age':1}.get('name')", oContext,oContext.getRoot());
				System.out.println(value2);
			} catch (OgnlException e) {
			
				e.printStackTrace();
			}
			
		  
		
		
	}
	
	
}
