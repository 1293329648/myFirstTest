package com.cjf.dao.impl;

import org.hibernate.Session;

import com.cjf.dao.LinkManDao;
import com.cjf.domain.LinkMan;
import com.cjf.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	public void save(LinkMan lm) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}

}
