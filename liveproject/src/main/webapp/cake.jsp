<%@page import="com.app.sa.userDTO.userDTO"%>
<%@page import="com.app.sa.userDAO.userDAO"%>
<%@page import="java.util.Random"%>
<%@page import="java.nio.file.FileSystemLoopException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.app.sa.cakeDAO.cakeDAO"%>
<%@page import="com.app.sa.cakeDTO.cakeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cake Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="icon" type="image/x-icon" href="https://cdn.iconscout.com/icon/premium/png-512-thumb/cake-2604074-2168304.png?f=avif&w=256">
<style>
#div2
{
  padding: 6px;
  display:flex;
  justify-content:space-between;
   background-color: black;
  color: silver;
}
#end
{
   color:silver;
   background-color: black;
   text-align: center;
}
#cakeshop
{
font-size: smaller;
}
#social ul li
{
  list-style-type: none;
}
::-webkit-scrollbar
{
   display: none;
}
.flex-div
{
 padding:3px;
  margin:1px;
  width:200px;
}

.container
{
  display: grid;
  text-align:center; 
  grid-template-columns: repeat(auto-fit, 13rem);
  justify-content: center;
  grid-gap:20px
}
#exampleModal
{
   text-align: center;
}
.div1 img
{
  width: 100%;
  padding: 2px;
  border-radius: 10px;
}
.div1
{
   background-color: white;
   border: 1px solid white;
   border-radius: 10px;
   height: 8cm;
}
.div1:hover
{
   box-shadow: 4px 4px 5px 5px rgba(0,0,0,.7);
}
.input1
{
    border:0;
    outline:0;
}
body
{
  background-color: rgb(215,206,230);
}
#logout
{ 
    margin-right: 3cm;
}
#user
{ 
   margin-right: 10px;
   border:1px solid blue;
   border-radius: 10%;
   text-align: center;
}
#user a
{
   text-decoration: none;
}
#logo
{
   border: 1px solid blue;
   border-radius: 100%;
   width: 30px;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="displaycartController"><i class="fa-solid fa-cart-shopping fa-shake"></i>Cart</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
      </ul>
    </div>
  </div>
  <div id="logout">
    <button type="button" class="btn btn-primary"><a href='LogoutController'><font color="black">Logout</font></a></button>
  </div>
  <div id="user">
  <button type="button"  data-bs-toggle="modal" data-bs-target="#exampleModal">
  <i id="logo" class="fa-solid fa-user" style="color: #2f68ca;"></i>User
  </button>
  </div>
</nav>
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
 %>
   <h4>Welcome<%=name %></h4>
   <%} %>
  <container class="container">
  <%
   Random ra = new Random();   
  List<cakeDTO>  cak = (List<cakeDTO>)request.getAttribute("cak");
  if(cak!=null)
  {

       for(cakeDTO dto:cak)
       {
  %>
  
  <div class="div1">
  <form action="viewcartController" method='post'>
    <img src="http://localhost:8081/liveproject/images/<%=dto.getCakename() %>.jpg" alt="noimage" ><br>
    <input type="text" value=<%=ra.nextInt(500) %> hidden="" name ="orderid">
    <input type="text" value=<%=dto.getCakeid() %> hidden="" name ="cakeid">
     <pre>
 Cakename:<input class="input1" type="text" value=<%=dto.getCakename() %> readonly="readonly" name ="cakename">
 Price   :<input class="input1" type="text" value=<%=dto.getPrice() %> readonly="readonly" name ="price">
 Kilogram:<input class="input1" type="text" value=<%=dto.getKilogram() %> readonly="readonly" name ="kilogram">
 Quantity:<input class="input1" type="text" value=<%=dto.getQuantity() %> readonly="readonly" name ="quantity"><br>
 <input type="submit" value='Add-Cart'>
   </pre>
   </form>
  </div>
<%}} %>
</container>
<br><br>
<div id="div2">
<div id="cakeshop" class="flex-div">
<h4>Online Cake Shop</h4>
   <ul>
   <li>Hot Breads has been baking since 1989! We are now back with our new online cake shop and more revolutionise baking again! Wait till you see what we have been up to these days to make 2022 extraordinary!</li>
   <li>All cakes at Hot Breads are baked freshly everyday for the cake shop!</li>
   </ul>
</div>
<div class="flex-div">   
<h4>Contact Cake Shop</h4>
<ul>
<li>Chennai Branch:044 5743636</li>
<li>Madurai Branch:0452 5436362</li>
<li>Coimbatore Branch:0422 6584653 </li>
</ul>   
</div>
<div class="flex-div">
<h4>Cake Support</h4>
<ul>
<li>Contact us</li>
<li>About us</li>
<li>Privacy policy</li>
<li>Refund Policy</li>
<li>FAQs</li>
<li>Terms of service</li>
<li>Refund policy</li>
</ul>
</div>
<div class="flex-div" id="social">
<h4>Social Media</h4>
<ul>
<li><i class="fa-brands fa-instagram fa-beat-fade fa-2xl"></i><br>Instagram</li>
<br>
<li><i class="fa-brands fa-facebook fa-beat-fade fa-2xl"></i><br>Facebook</li>
<br>
<li><i class="fa-brands fa-whatsapp fa-beat-fade fa-2xl"></i><br>Whatsapp</li>
</ul>
</div>
</div>
<div id="end">
<p>Shop for Birthday Cakes and Anniversary Cakes! Our Cake shop is open* 24x7 for cake ordering and delivery in Chennai, Madurai, Coimbatore</p>
 <h2>Thank You</h2>
</div>

<%
userDAO dao = new userDAO();
HttpSession ses1 = request.getSession(false);
if(ses1!=null)
{
	String username = (String)ses1.getAttribute("un");
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
        <h3 class="modal-title" id="exampleModalLabel">Profile</h3>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       <h5>NAME:<%=detail.getName() %></h5>
       <h5>USERNAME:<%=detail.getUsername() %></h5>
       <h5>CONTACT:<%=detail.getContact() %></h5>
      </div>
      <div class="modal-footer">
         <p>Thank You</p>
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
</body>
</html>