package com.cjf.service.impl;



import com.cjf.dao.UserDao;
import com.cjf.dao.impl.UserDaoImpl;
import com.cjf.domain.User;
import com.cjf.service.UserService;
import com.cjf.utils.HibernateUtils;

public class UserServiceImpl implements UserService {
   UserDao ud;
	public UserDao getUd() {
	return ud;
}
public void setUd(UserDao ud) {
	this.ud = ud;
}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
	
		HibernateUtils.getCurrentSession().beginTransaction();
		  User isu=ud.getByUserCode(user.getUser_code());
		HibernateUtils.getCurrentSession().getTransaction().commit();
	   if(isu==null) {
		   throw new RuntimeException("用户名不存在！");	   
		   }		   
	   if(!isu.getUser_password().equals(user.getUser_password())){
		   throw new RuntimeException("密码错误！");	  
	   }
	    return isu;
	}	
}
   
