<%@page import="java.util.List"%>
<%@page import="com.axelor.db.People"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	
	<script type="text/javascript">
		function addData() {
			var name = document.getElementById("name")
			alert("Data added successfully !");
			
		}
	</script>
	
	<form action="People/createPeople" method="post">
		<h1>Add People</h1>
		<label for="name">Name:</label> <input type="text" name="name" id = "name"><br>
		<input type="submit" onclick = "addData()" value="submit">
	</form>
	<br>
	<h2>Display People details</h2>
	
	<h3><a href = "People/showPeople"> Click Here to Display Data</a></h3>
	
	
</body>
</html>