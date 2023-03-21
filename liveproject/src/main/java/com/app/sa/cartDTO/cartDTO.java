package com.app.sa.cartDTO;

public class cartDTO
{
  private int orderid;
  private int cakeid;
  private String username;
  private String cakename;
  private double price;
  private String kilogram;
  
  public cartDTO() {}

public cartDTO(int orderid, int cakeid, String username, String cakename, double price, String kilogram) 
{
	this.orderid= orderid;
	this.cakeid = cakeid;
	this.username = username;
	this.cakename = cakename;
	this.price = price;
	this.kilogram = kilogram;
}


public int getOrderid() 
{
	return orderid;
}

public void setOrderid(int orderid) 
{
	this.orderid = orderid;
}

public int getCakeid() 
{
	return cakeid;
}

public void setCakeid(int cakeid) 
{
	this.cakeid = cakeid;
}

public String getUsername() 
{
	return username;
}

public void setUsername(String username) 
{
	this.username = username;
}

public String getCakename() 
{
	return cakename;
}

public void setCakename(String cakename) 
{
	this.cakename = cakename;
}

public double getPrice() 
{
	return price;
}

public void setPrice(double price) 
{
	this.price = price;
}

public String getKilogram() 
{
	return kilogram;
}

public void setKilogram(String kilogram) 
{
	this.kilogram = kilogram;
}
  

  
}
