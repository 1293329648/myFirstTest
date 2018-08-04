package com.cjf.dao;

import com.cjf.domain.User;

public interface UserDao {
	
	//根据登陆名称查询user对象
	User getByUserCode(String user_code);

}