package com.app.sa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil
{
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getConnection() 
	{
		Connection c = null;

		try 
		{
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake?user=root&password=Sabari");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return c;
	}
	public static void Close(Connection c)
	{
		if(c!=null)
		{
			try
			{
				c.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
