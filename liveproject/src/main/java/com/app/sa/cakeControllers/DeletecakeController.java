package com.app.sa.cakeControllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.app.sa.cakeDAO.cakeDAO;

public class DeletecakeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("deletecake.jsp");
		String msg = "";
		cakeDAO dao = new cakeDAO();
		
		int cakeid = Integer.parseInt(request.getParameter("cakeid"));
		
		try
		{
			if(dao.delete(cakeid))
			{
				msg="Deleted Successfully";
			}
			else
			{
				msg="Invalid Id";
			}
		}
		catch (SQLException e) 
		{
			msg="Server Error!!!";
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		rd.forward(request, response);
	}

}
