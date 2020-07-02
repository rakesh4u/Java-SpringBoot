<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import	= "com.example.demo.controller.*" session="true" %>
    
   <jsp:include page="../headers/headerlogin.jsp" />
       <style>
    .card {
		  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
		  transition: 0.3s;
		  width: 100%;
		}
</style>
<body>
<div class = "container" style = "margin-top: 50px;width: 60%;">

<div class = "card">
<div class = "card-header" style = " margin: 0px ;background-color: #007bff">
<h3 style = "text-align: center;margin-top: 10px; color: white">Login</h3>
</div>




<form action="/dash/dashboard" method = "POST">
	<div class = "container card-body" >
			<form-group style = "display:inline">
			<label>Username</label>
			<input type = "text" id = "username" name = "username" class = "form-control" autocomplete = "off" required/>
			</form-group>
			<br>
			<form-group>
			<label>Password</label>
			<input type = "password" id = "password" name = "password" class = "form-control"  autocomplete = "off" required/>
			</form-group>
			<br>
			<button type = "submit" class = "btn btn-info">Login</button>
			<a role = "button" href = "/register" class = "btn btn-default">Register</a>

	</div>

</form>
<br>
</div>

<br>
</div>

</body>
</body>

