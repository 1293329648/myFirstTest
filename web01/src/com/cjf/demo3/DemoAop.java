package com.cjf.demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration("classpath:applicationContext.xml")
public class DemoAop {
@Resource(name="userService")
User1Service user1Service;
@Test
public void Test1() {
	user1Service.save();	
}

}
