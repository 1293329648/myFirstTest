package com.cjf.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cjf.dao.UserDao;
import com.cjf.domain.User;

//HibernateDaoSupport 为dao注入sessionFactory
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	@Override
	public User getByUserCode(final String user_code) {		
		/*
	 	private Integer user_id;
	    private  String user_code;
	    private  String user_name;
	    private  String user_password;
	    private  String user_state;
	 */
		String sql = "select * from sys_user where user_code = ? ";
		return super.getJdbcTemplate().queryForObject(sql,new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
			  u.setUser_id(rs.getInt("user_id"));
			  u.setUser_code(rs.getString("user_code"));
			  u.setUser_name(rs.getString("user_name"));
			  u.setUser_password(rs.getString("user_password"));
			  u.setUser_state(rs.getString("user_state"));
			  
				return u;
			}}, user_code);
	}
}
