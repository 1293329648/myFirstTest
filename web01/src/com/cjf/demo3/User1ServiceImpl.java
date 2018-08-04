package com.cjf.demo3;

public class User1ServiceImpl  implements User1Service{

	@Override
	public void save() {
	
	  System.out.println("添加用户！！！");	
	}

	@Override
	public void query() {
		System.out.println("查询用户！！！");
		
	}

}
