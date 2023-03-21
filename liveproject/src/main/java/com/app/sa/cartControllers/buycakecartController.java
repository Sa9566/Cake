package com.app.sa.cartControllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.app.sa.cartDAO.cartDAO;

public class buycakecartController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("final.jsp");
		String msg = "";
		cartDAO dao = new cartDAO();
		
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		
		try
		{
			if(dao.update(orderid)==false)
			{
				msg="Purchased Succesfully";	
			}
			else
			{
				msg="something Wrong";
			}
			
		} 
		catch (SQLException e) 
		{
			msg = "Server Error!!!";
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		rd.forward(request, response);
	}

}
