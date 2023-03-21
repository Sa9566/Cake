<%@page import="com.app.sa.cakeDTO.cakeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Cake</title>
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
            <input type="hidden" name='option' value='update'>
  CAKEID  : <input type="text" name='cakeid'>
  <input type="reset" value="Clear"> <input type="submit" value="Search-Cake">
</pre>
</form>

<form method="post" action="UpdatecakeController">
<table>
  <%
   cakeDTO dto = (cakeDTO)request.getAttribute("dto");
   if(dto!=null)
   {
  %>
  <tr>
    <td>CAKEID  : <input type="text" name="cakeid" value=<%=dto.getCakeid() %> readonly="readonly"></td>
    <td>CAKENAME: <input type="text" name="cakename" value=<%=dto.getCakename() %>></td>
    <td>PRICE   : <input type="text" name="price" value=<%=dto.getPrice() %> ></td>
    <td>QUANTITY: <input type="text" name="quantity" value=<%=dto.getQuantity() %> ></td> 
    <td>KILOGRAM: <input type="text" name="kilogram" value=<%=dto.getKilogram() %> ></td>  
    <td><input type="submit" value="Update-Cake"></td>
  </tr>
  <%} %>
</table>
<h3><a href='admin.jsp'>Back</a></h3>
</form>
</body>
</html>