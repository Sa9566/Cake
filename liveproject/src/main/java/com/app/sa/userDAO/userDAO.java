package com.app.sa.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.sa.userDTO.userDTO;
import com.app.sa.util.Dbutil;


public class userDAO
{
	public boolean register(userDTO dto) throws SQLException
	{
		boolean r = true;

		Connection c = Dbutil.getConnection();

		PreparedStatement ps = c.prepareStatement("insert into registerpage values(?,?,?,?)");
		ps.setString(1, dto.getUsername());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getContact());
		ps.setString(4, dto.getName());

		int nori = ps.executeUpdate();

		if(nori!=1)
		{
			r = false;
		}

		Dbutil.Close(c);
		return r;
	}
	public boolean login(userDTO dto) throws SQLException
	{

		boolean res = true;

		Connection c = Dbutil.getConnection();

		PreparedStatement ps = c.prepareStatement("select * from registerpage where username=? and password=?");
		ps.setString(1, dto.getUsername());
		ps.setString(2, dto.getPassword());
        
		ResultSet r = ps.executeQuery();

		if(r.next()==false)
		{
			res = false;
		}

		Dbutil.Close(c);
		return res;

	}
	public boolean login1(userDTO dto) throws SQLException
	{
		boolean res = true;

		Connection c = Dbutil.getConnection();

		PreparedStatement ps = c.prepareStatement("select * from users where username=? and password=?");
		ps.setString(1, dto.getUsername());
		ps.setString(2, dto.getPassword());

		ResultSet r = ps.executeQuery();

		if(r.next() == false)
		{
			return false;
		}
		Dbutil.Close(c);
		return res;
	}
	public List<userDTO> display()
	{
		List<userDTO> us = new ArrayList<>();
		
		Connection c = Dbutil.getConnection();
		
		try
		{
			PreparedStatement ps = c.prepareStatement("Select * from registerpage");
		     
		    ResultSet r = ps.executeQuery();
		     
		    while(r.next())
		    {
		    	userDTO dto = new userDTO();
		    	dto.setUsername(r.getString(1));
		    	dto.setPassword(r.getString(2));
		    	dto.setContact(r.getString(3));
		    	dto.setName(r.getString(4));
		    	us.add(dto);
		    }
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		Dbutil.Close(c);
		return us;
	}
}
