package com.cjf.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car3")
public class Car {
	@Value(value="aaa")
	private String  name;
	@Value(value="red")
	private String color;
	
	public String getName() {
		return name;
	}   
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}
	
	
}
