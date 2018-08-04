package com.cjf.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cjf.domain.Customer;
import com.cjf.service.CustomerService;
import com.cjf.service.UserService;
import com.cjf.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private static final long serialVersionUID = 1L;
	private Customer customer=new Customer();
	private CustomerService cs ;	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	//添加客户
	public String add() {		
        ServletContext sc = ServletActionContext.getServletContext();
        //从sc中获得wac容器
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        CustomerService cs=(CustomerService)wac.getBean("customerService");
		cs.save(customer);
		return "toList";
	}
	
	 
	//查询所有顾客
	public String list() {
		
        ServletContext sc = ServletActionContext.getServletContext();
        //从sc中获得wac容器
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        CustomerService cs=(CustomerService)wac.getBean("customerService");
        
		//1获得查询条件
		String cust_name = customer.getCust_name();
		//2判断查询条件是否不为空
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		if(cust_name!=null && !"".equals(cust_name)){
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
			//不为空=>添加条件
		//3 调用Service查询所有客户
		List<Customer> list = cs.getAll(dc);
		//4 将客户列表放入request域    
		
		ActionContext.getContext().put("list", list);
		//ServletActionContext.getRequest().setAttribute("list", list);
		//5 转发到list.jsp显示
		//request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
		
		return "list";
	}

	
    }



