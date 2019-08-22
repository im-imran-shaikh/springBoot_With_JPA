package com.springBoot.CRUDWithJpaAndH2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SmartPhone
{
	@Id
	@GeneratedValue
	private int Id;
	private String brand;
	private String model;
	private int price;
	
	public int getId()
	{
		return Id;
	}
	public void setId(int id)
	{
		Id = id;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	
}
