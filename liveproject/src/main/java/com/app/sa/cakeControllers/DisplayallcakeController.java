package com.app.sa.cakeControllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.app.sa.cakeDAO.cakeDAO;
import com.app.sa.cakeDTO.cakeDTO;

public class DisplayallcakeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("displayallcake.jsp");
		RequestDispatcher rd1 = request.getRequestDispatcher("cake.jsp");
		cakeDAO dao = new cakeDAO();
		String msg = "";
		
		try 
		{
			
			List<cakeDTO> cak = dao.displayall();
			if(cak.isEmpty())
			{
				msg="No Records Found";
			 request.setAttribute("msg", msg);	
			}
			else
			{
			  request.setAttribute("cak", cak);
			}
		}
		catch (SQLException e) 
		{
			msg="Server Error!!!";
			e.printStackTrace();
		}
		rd.forward(request, response);
		rd1.forward(request, response);
	}

}
