package com.cjf.bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("user11")
//@Controller("user1")  //web
//@Service("user2")
//@Repository("user3")  //dao
@Scope(scopeName="prototype")   
/*singleton 只有一个实例，也即是单例模式。prototype访问一次创建一个实例，相当于new*/
public class User {
	private Map<String,Object> map;//map类型注入
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public User() {
			System.out.println("User .......");
	}
	@Value("cjf")
	private String name;
	@Value(value="20")
	private Integer age;
	@Autowired //自动装配
  //@Resource(name="car2")

	@Resource(name="car3")
	//@Qualifier("car2")   //与自动装配配套使用
	private Car car;
	
	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public User(String name, Car car) {
		System.out.println("User(String name, Car car)!!");
		this.name = name;
		this.car = car;
	}
	
	public User(Car car,String name) {
		System.out.println("User(Car car,String name)!!");
		this.name = name;
		this.car = car;
	}
	
	public User(Integer name, Car car) {
		System.out.println("User(Integer name, Car car)!!");
		this.name = name+"";
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@PostConstruct   //初始化执行
	public void init(){
		System.out.println("0.init..0.!");
	}
	@PreDestroy   //销毁之前执行
	public void destory(){
		System.out.println("!!destroy!!!!");
	}

	@Override
	public String toString() {
		return "User [map=" + map + ", name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
}
