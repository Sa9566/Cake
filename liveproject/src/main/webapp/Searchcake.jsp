<%@page import="com.app.sa.cakeDTO.cakeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
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

<form method="post" action="SearchcakeController">
<pre>
            <input type="hidden" name='option' value='search'>
  CAKEID  : <input type="text" name='cakeid'>
  <input type="reset" value="Clear"> <input type="submit" value="Search-Cake">
</pre>
</form>
<table>
  <tr>
    <th>CAKEID</th>
    <th>CAKENAME</th>
    <th>PRICE</th>
    <th>QUANTITY</th>
  </tr>
  <%
    cakeDTO dto = (cakeDTO)request.getAttribute("dto");
    if(dto!=null)
    {
  %>
  <tr>
    <td><%=dto.getCakeid() %></td>
    <td><%=dto.getCakename() %></td>
    <td><%=dto.getPrice() %></td>
    <td><%=dto.getPrice() %></td>
  </tr>
  <%} %>
</table>
<h3><a href='admin.jsp'>Back</a></h3>
</body>
</html>