package com.app.sa.cakeDTO;

public class cakeDTO 
{
	private int cakeid;
	private String cakename;
	private double price;
	private int quantity;
	private String kilogram;

	public cakeDTO() {}

	public cakeDTO(int cakeid, String cakename, double price, int quantity,String kilogram) 
	{
		super();
		this.cakeid = cakeid;
		this.cakename = cakename;
		this.price = price;
		this.quantity = quantity;
		this.kilogram= kilogram;
	}

	public int getCakeid() {
		return cakeid;
	}

	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
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

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
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
