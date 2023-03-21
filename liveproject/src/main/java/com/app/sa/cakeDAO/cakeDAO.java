package com.app.sa.cakeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.sa.cakeDTO.cakeDTO;
import com.app.sa.util.Dbutil;

public class cakeDAO 
{
	public boolean insert(cakeDTO dto) throws SQLException
	{
		boolean r = true;

		Connection c = Dbutil.getConnection();

		PreparedStatement ps = c.prepareStatement("insert into cakepage values(?,?,?,?,?)");
		ps.setInt(1, dto.getCakeid());
		ps.setString(2, dto.getCakename());
		ps.setDouble(3, dto.getPrice());
		ps.setInt(4, dto.getQuantity());
        ps.setString(5, dto.getKilogram()); 
		
		int nori = ps.executeUpdate();
		if(nori!=1)
		{
			r = false;
		}
		Dbutil.Close(c);
		return r;
	}
	public boolean delete(int cakeid) throws SQLException
	{
		boolean r = true;

		Connection c = Dbutil.getConnection();
		
		PreparedStatement ps = c.prepareStatement("delete from cakepage where cakeid=?");
		ps.setInt(1, cakeid);
		
		int nord = ps.executeUpdate();
		if(nord!=1)
		{
			r = false;
		}
		Dbutil.Close(c);
		return r;
	}
	public cakeDTO search(int cakeid) throws SQLException
	{
		cakeDTO dto = null; 

		List<cakeDTO> sear = displayall();

		for(cakeDTO dto1:sear)
		{
			if(dto1.getCakeid()==cakeid)
			{
				dto = dto1;
			}
		}

		return dto;
	}
	public boolean update(cakeDTO dto) throws SQLException
	{
		boolean r = true;
		
		Connection c = Dbutil.getConnection();
		
		PreparedStatement ps = c.prepareStatement("update cakepage set cakename=?,price=?,quantity=?,kilogram=? where cakeid=?");
		ps.setString(1, dto.getCakename());
		ps.setDouble(2, dto.getPrice());
		ps.setInt(3, dto.getQuantity());
		ps.setString(4, dto.getKilogram());
		ps.setInt(5, dto.getCakeid());
		
		int noru = ps.executeUpdate();
		
		if(noru!=1)
		{
			r = false;
		}
		
		Dbutil.Close(c);
		return r;
	}
	public List<cakeDTO> displayall() throws SQLException
	{
		List<cakeDTO> cak = new ArrayList<cakeDTO>();

		Connection c = Dbutil.getConnection();

		PreparedStatement ps = c.prepareStatement("select * from cakepage");

		ResultSet r = ps.executeQuery();

		while(r.next())
		{
			cakeDTO dto = new cakeDTO();
			dto.setCakeid(r.getInt(1));
			dto.setCakename(r.getString(2));
			dto.setPrice(r.getDouble(3));
			dto.setQuantity(r.getInt(4));
			dto.setKilogram(r.getString(5));
			cak.add(dto);
		}
		Dbutil.Close(c);
		return cak;
	}

}
