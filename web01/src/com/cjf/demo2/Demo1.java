package com.cjf.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cjf.bean.User;

public class Demo1 {

	@Test
	public void Test1() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user11");
		User user1 = (User)ac.getBean("user11");
		
		System.out.println(user==user1);
		
	}
	@Test
	public void Test2() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user11");

		
		System.out.println(user);
		
	}
}
