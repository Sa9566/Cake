package com.app.sa.test;

import java.sql.SQLException;
import java.util.List;

import com.app.sa.cartDAO.cartDAO;
import com.app.sa.cartDTO.cartDTO;

public class test 
{
    public static void main(String[] args)
    {
     	cartDAO dao = new cartDAO();
     	try {
			dao.delete(17);
			System.out.println("scs");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//      	
//      	
//      	try
//      	{
//			dao.update(19);
//			System.out.println("succ");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//      	
//	    cartDTO dto= new cartDTO(543, "sabari", "Blackforest", 250.0, "2kg");	
//	   try
//	   {
//		   dao.insert(dto);
//		   System.out.println("ssdad");
//	   }
//	   catch (SQLException e) 
//	   {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	   }
	   
//	   try {
//		List<cartDTO> cart = dao.displayall();
//		for(cartDTO d:cart)
//		{
//			System.out.println(d.getCakename());
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
    }
}
