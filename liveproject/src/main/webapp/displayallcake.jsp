<%@page import="java.util.List"%>
<%@page import="com.app.sa.cakeDTO.cakeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


<table border="1px" style="width:8cm; border-collapse: collapse; text-align: center;">
  <%
   List<cakeDTO> cak = (List<cakeDTO>)request.getAttribute("cak");
  if(cak!=null) 
  {%>
	  <tr>
  <th>CAKEID</th>
  <th>CAKENAME</th>
  <th>PRICE</th>
  <th>QUANTITY</th>
  <th>KILOGRAM</th>
     </tr>
     <%
  for(cakeDTO dto:cak)
     {%>
  <tr>
    <td><%= dto.getCakeid() %></td>
    <td><%= dto.getCakename() %></td>
    <td><%= dto.getPrice() %></td>
    <td><%= dto.getQuantity() %></td>
    <td><%= dto.getKilogram() %></td>
  </tr>
  <%}
  }
  %>
</table>
<h3><a href='admin.jsp'>Back</a></h3>
</body>
</html>