<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Cake</title>
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

<form method="post" action="DeletecakeController">
<pre>
  CAKEID  : <input type="text" name='cakeid'>
  <input type="reset" value="Clear"> <input type="submit" value="Delete-Cake">
</pre>
</form>
<h3><a href='admin.jsp'>Back</a></h3>
</body>
</html>