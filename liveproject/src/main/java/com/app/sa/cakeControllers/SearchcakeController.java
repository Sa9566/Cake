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

public class SearchcakeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		cakeDAO dao = new cakeDAO();
		RequestDispatcher rd = request.getRequestDispatcher("Searchcake.jsp");
		RequestDispatcher rd1 = request.getRequestDispatcher("updatecake.jsp");
		String op = request.getParameter("option");
		String msg = "";
		
		int cakeid = Integer.parseInt(request.getParameter("cakeid"));
		
	    try
	    {
			cakeDTO dto = dao.search(cakeid);
			if(dto!=null)
			{
				request.setAttribute("dto", dto);
			}
			else
			{
				msg="Invalid Id";
				request.setAttribute("msg", msg);
			}
		}
	    catch (SQLException e) 
	    {
	    	msg="Server Error!!!";
			e.printStackTrace();
		}
	    
	    if(op.equals("search"))
	    {
	    	rd.forward(request, response);
	    }
	    else
	    {
	    	rd1.forward(request, response);
	    }
	    
	}

}
