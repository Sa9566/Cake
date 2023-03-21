package com.app.sa.cartControllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.app.sa.cakeDAO.cakeDAO;
import com.app.sa.cakeDTO.cakeDTO;
import com.app.sa.cartDAO.cartDAO;
import com.app.sa.cartDTO.cartDTO;

public class viewcartController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		RequestDispatcher rd = request.getRequestDispatcher("cake.jsp");
		String msg = "";
        cartDAO dao = new cartDAO();
        
        HttpSession ses = request.getSession(false);
        String name = (String)ses.getAttribute("un");
        String cakename = request.getParameter("cakename");
        String kilogram = request.getParameter("kilogram");
        double price = Double.parseDouble(request.getParameter("price"));
        int cakeid = Integer.parseInt(request.getParameter("cakeid"));
        int id = Integer.parseInt(request.getParameter("orderid"));
        
        
        cartDTO dto = new cartDTO(id,cakeid, name, cakename, price, kilogram);
        cakeDAO dao1 = new cakeDAO();
        try
        {
			if(dao.insert(dto))
			{
				try 
				{
					ses = request.getSession(true);
					List<cakeDTO> cak = dao1.displayall();
					ses.setAttribute("un", dto.getUsername());
					if(cak.isEmpty())
					{
						msg="No Records Found";	
					}
					else
					{
					  
					  request.setAttribute("cak", cak);
					  rd.forward(request, response);
					}
				}
				catch (SQLException e) 
				{
					msg="Server Error!!!";
					e.printStackTrace();
				}    
			}
			else
			{
				
				msg = "Something Wrong";
			
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
