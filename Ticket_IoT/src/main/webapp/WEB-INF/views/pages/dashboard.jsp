<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="../headers/header.jsp" />
    <style>
    
    .card {
		  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
		  transition: 0.3s;
		  width: 100%;
		}
		
    .tor{
    margin: 2px;  
    
    }
    .to-right{
     float: left;
  width: 25%;
  text-align: right;
  margin: 10px 10px;
  display: inline; 
  height: 300px;
  overflow-y: scroll;
    }
    .to-rights{
     float: left;
  width: 25%;
  text-align: right;
  margin: 10px 10px;
  margin-top: -25px;
  display: inline; 
  height: 380px;
  overflow-y: scroll;
    }
    .to-left{
     float: left;
  width: 75%;
  text-align: right;
  margin: 10px 10px;
  display: inline;
  height: 350px;
    }
    .card-header ,.card-body{
    text-align: left; 
    margin-left: -15px ;
    margin-right: -15px ;
   
    }
   
    
    </style>
<body>
<div class= " col-sm-12" style = " width: 100%; margin: 20px">

	<div class = "col-sm-4 card tor to-right">
	
	<div class = "card-header">
	Node Information
	</div>
	<div class = "card-body" >
	${hello}
	
	${nodes}
	</div>
	
	</div>
	
	<div class = "col-sm-8 card tor to-left">
	
	<div style = "text-align: center; margin-top: 150px" id = "nodes">
		<a href = "/nodes/nodeAdd" style = "color: grey; text-decoration: none;" id = "nodeadd">Click <b>Here</b> to Add new Nodes +</a>&nbsp;
	</div>
	
	</div>

</div>

<div class= " col-sm-12" style = " width: 100%; margin: 20px">

	<div class = "col-sm-4 card tor to-rights">
	
	<div class = "card-header">
	Control Devices
	</div>
	<div class = "card-body" >
	
		${controlnodes}
	</div>
	
	</div>
	
	<div class = "col-sm-8 card tor to-left">
	
	
	</div>

</div>
</body>

<script>

//alert($("#types").val());

$(document).ready(function(){
	var text = "";
	var type = $("#types").val();
	if(type != 1){

			$("#nodeadd").hide();
			$(".adm").remove();
			text = text + "<p style = 'color: grey'><i class='fa fa-warning'></i> You have no right to create node</p>";
			$("#nodes").html(text);
		
		}
});

$.ajax({
		url:"http://localhost:8080/dash/dashs",
		success:function(){
			
			}
		});


function deletes(id){

	$.ajax({
		url:"http://localhost:8080/nodes/deletenode?i="+id,
		success:function(){
			toastr.success("Deleted Successfully");
			location.reload(true);
			}
		});
	
	
	
}
$("#logout").click(function(){
	toastr.success("Logout Successfully");
});


</script>