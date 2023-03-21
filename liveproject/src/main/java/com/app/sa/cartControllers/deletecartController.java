package com.app.sa.cartControllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.app.sa.cartDAO.cartDAO;
import com.app.sa.cartDTO.cartDTO;

public class deletecartController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("viewcart.jsp");
		String msg = "";
		cartDAO dao = new cartDAO();
		
		int orderid = Integer.parseInt(request.getParameter("orderid"));
         
		
		try
		{
			if(dao.delete(orderid))
			{
				List<cartDTO> cart = dao.displayall();
				if(cart.isEmpty())
				{
					msg="No Data Found";
					request.setAttribute("msg", msg);
				}
				else
				{
					request.setAttribute("cart", cart);
					rd.forward(request, response);
				}
			}
			else
			{
				msg="Something Wrong";
			}
		}
		catch (SQLException e) 
		{
			msg = "Server Error!!!";
			e.printStackTrace();
		}
	}

}
