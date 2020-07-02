<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import	= "com.example.demo.controller.*" %>
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
<h3 style = "text-align: center;margin-top: 10px; color: white">Register</h3>
</div>




<form action="/setRegister" method = "POST">
	<div class = "container card-body" >
			<form-group style = "display:inline">
			<label>Username</label>
			<input type = "text" id = "username" name = "username" class = "form-control" autocomplete = "off" required/>
			</form-group>
			<br>
			<form-group>
			<label>Password</label>
			<input type = "text" id = "password" name = "password" class = "form-control"  autocomplete = "off" required/>
			</form-group>
			<form-group>
			<label>Mobile</label>
			<input type = "text" id = "mobile" name = "mobile" class = "form-control"  autocomplete = "off" required/>
			</form-group>
			<form-group>
			<label>User Type</label>
			<select name = "user_type" id = "user_type" class = "form-control">
				<option value = "1">Admin</option>
				<option value = "2">General</option>
			</select>
			</form-group>
			<br>
			<button type = "submit" id = "sub"  class = "btn btn-info">Register</button>
			<span class = "pull-right">
				<a role = "button" href = "/" class = "btn btn-default" type = "button">Back to Login</a>
			</span>
			

	</div>

</form>
<br>
</div>

<br>
</div>

</body>
</body>
<script>

	$("#sub").click(function(){

		toastr.success("Saved Successfully");
		
		});

</script>