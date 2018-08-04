
package com.cjf.demo3;

import org.junit.Test;

public class Demo {
   
	@Test
	public void Test1() {
		User1Service us =new User1ServiceImpl();
		
		UserServiceProxy factory=new UserServiceProxy(us);
		
		User1Service usproxy = factory.getProxyUserService();
		usproxy.save();
		
	}
	
}
