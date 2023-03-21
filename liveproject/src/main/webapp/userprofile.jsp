<%@page import="java.util.List"%>
<%@page import="com.app.sa.userDTO.userDTO"%>
<%@page import="com.app.sa.userDAO.userDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<%
userDAO dao = new userDAO();
HttpSession ses = request.getSession(false);
if(ses!=null)
{
	String username = (String)ses.getAttribute("un");
  List<userDTO> dto =  dao.display();
   {
	  for(userDTO detail :dto)
	  {
	     if(username.equals(detail.getUsername()))
	     {
%>
 <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" style="color:red;">Warning!</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       <h3 style="color:red"><%=detail.getName() %></h3>
      </div>
      <div class="modal-footer">
         <p>Press Back To Go Login Page...</p>
        <button type="button" class="btn btn-primary"><a href='index.html'><font color="Black">Back</font></a></button>
      </div>
    </div>
  </div>
</div>      
 <%
	     }
	  }
   }
} 
 %>               

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript">
const myModal = new bootstrap.Modal('#exampleModal');
window.addEventListener('DOMContentLoaded',()=>{
	myModal.show();
});
</script>
</body>
</html>