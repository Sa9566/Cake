<%@page import="com.app.sa.cartDTO.cartDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
</head>
<body>
 <%
  String msg = (String)request.getAttribute("msg");
  if(msg!=null)
  {
%>
   <h2><font color="green"><%= msg %></font></h2>
<%}
%>
    <%
    HttpSession ses = request.getSession(false);
    if(ses!=null)
    {
  	   String name = (String)ses.getAttribute("un");
     List<cartDTO> cart = (List<cartDTO>)request.getAttribute("cart");
     if(cart!=null)
     {
     for(cartDTO dto:cart)
     {
    	 if(name.equals(dto.getUsername()))
    	 {
 %> 
        <table border="1px" style="border-collapse: collapse; ">
  <tr>
    <th>ORDERID</th>
    <th>CAKENAME</th>
    <th>KILOGRAM</th>
    <th>PRICE</th>
    <th>
    <form action="deletecartController" method="post">
      <input type="text" name='orderid' value=<%=dto.getOrderid()%> hidden="">
      <input type="submit" value="Remove">
    </form>
    </th>
  </tr>
  <tr>
    <td><%=dto.getOrderid() %></td>
    <td><%=dto.getCakename() %></td>
    <td><%=dto.getKilogram() %></td>
    <td><%=dto.getPrice() %></td>
    <td>
      <form action="buycakecartController" method="post">
      <input type="text" name='orderid' value=<%=dto.getOrderid()%> hidden="">
      <input type="submit" value="Buy">
    </form>
    </td>
  </tr>
</table>
      
 <br>
 <br>
  <%}
     } 	 
     }
    }
   %> 
</body>
</html>