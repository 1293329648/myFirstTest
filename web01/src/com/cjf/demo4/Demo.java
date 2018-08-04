package com.cjf.demo4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cjf.demo3.User1Service;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/cjf/demo4/applicationContext.xml")
public class Demo {
     @Resource(name="userService")
	 User1Service us;
	
@Test
public void  Test1() {
	us.save();
}
	
	
}
