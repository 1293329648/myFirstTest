package com.cjf.service.impl;

import com.cjf.dao.CustomerDao;
import com.cjf.dao.LinkManDao;
import com.cjf.dao.impl.CustomerDaoImpl;
import com.cjf.dao.impl.LinkManDaoImpl;
import com.cjf.domain.Customer;
import com.cjf.domain.LinkMan;
import com.cjf.service.LinkManService;
import com.cjf.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	public CustomerDao getCd() {
		return cd;
	}
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	public LinkManDao getLmd() {
		return lmd;
	}
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	private CustomerDao cd ;
	private LinkManDao lmd ;
	public void save(LinkMan lm) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			//1 根据客户id获得客户对象
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			//2 将客户放入LinkMan中表达关系
			lm.setCustomer(c);
			//3 保存LinkMan
			lmd.save(lm);
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		//提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
	}

}
