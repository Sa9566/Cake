package com.app.sa.userDTO;

public class userDTO
{
	private String username;
	private String password;
	private String contact;
	private String name;

	public userDTO() {}

	public userDTO(String username, String password, String contact, String name)
	{
		super();
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.name = name;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getContact() 
	{
		return contact;
	}

	public void setContact(String contact) 
	{
		this.contact = contact;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}



}
