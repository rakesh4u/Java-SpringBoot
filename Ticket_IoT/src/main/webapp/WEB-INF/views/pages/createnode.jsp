<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="../headers/header.jsp" />
    
    <style>
    .card {
		  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
		  transition: 0.3s;
		  width: 100%;
		}
</style>
<body>


<div class = "container">
<br>
<div class = "card">
<form back = "/dashes" action = "save" method = "POST">
<br>
<div class = "container">
<div class = "card-header" style = " text-align:center; background-color:#007bff ;margin:-15px; margin-top: -25px">
<h3>Create Node</h3>
</div>
<br>
<div class = "card-body">

<form-group>
	<label>Node Id</label>
	<input type = "text" id = "node_id" name = "node_id" class = "form-control" required autocomplete = "off"/>
	</form-group>
	
	<form-group>
	<label>Operational Role</label>
	<select name = "op_mode" id = "op_mode" class = "form-control">
		<option value = "Aquisition Node">Aquisition Node</option>
		<option value = "Control Node">Control Node</option>
	</select>
	</form-group>
	
	<form-group id = "proto">
	<label>Operational Protocol</label>
	<select name = "op_protocol" id = "op_protocol" class = "form-control">
		<option value = "JSON">JSON</option>
		<option value = "MQTTP">MQTTP</option>
	</select>
	</form-group>
	
	<form-group >
	<label>Action Status</label>
	<select name = "act_stat" id = "act_stat" class = "form-control">
		<option value = "No">No</option>
		<option value = "Yes">Yes</option>
	</select>
	</form-group>
	<br>
	<button class = "btn btn-info" id = "sub" type = "submit">Save</button>
	<span class = "pull-right">
		<a role = "button" href = "/dash/todash" class = "btn btn-default" type = "button">Back</a>
	</span>

</div>
	
</div>
</form>
<br>
</div>
</div>

</body>

<script>

$("#sub").click(function(){
	toastr.success("Saved Successfully");
});

$("#op_mode").change(function(){
	if($("#op_mode").val() == "Control Node")
		$("#proto").hide();
	else
		$("#proto").show();
});

</script>




