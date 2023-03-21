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
import com.app.sa.cakeDTO.cakeDTO;

public class AddcakeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("addcake.jsp");
		String msg="";
		cakeDAO dao = new cakeDAO();
		
		int cakeid = Integer.parseInt(request.getParameter("cakeid"));
		String cakename = request.getParameter("cakename");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String kilo = request.getParameter("kilogram");
		cakeDTO dto = new cakeDTO(cakeid, cakename, price, quantity,kilo);
		
		try
		{
			if(dao.insert(dto))
			{
				msg="Cake Added Sucessfully";
			}
			else
			{
				msg="Something Wrong";
			}
		}
		catch (SQLException e) 
		{
			msg="Server Error!!!!";
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		rd.forward(request, response);
	}
}
