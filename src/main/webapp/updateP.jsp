<%@page import="javax.ws.rs.Path"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import=" java.util.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.io.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Data</title>
</head>
<body>

	<form action="../People/updatePeople" method="post">
		<h2>Add ID and change name</h2>
		<label for="id">ID:</label> <input type="number" name="id"
			value="<%out.print(request.getAttribute("uid"));%>" readonly><br>
		<label for="name">Name:</label> <input type="text" name="name"
			value="<%out.print(request.getAttribute("name"));%>"><br>
		<input type="submit" onclick= "updateData()" value="Update">
	</form>
	<script type="text/javascript">
		function updateData() {
			alert("Data has been Updated");
		}
	</script>
</body>
</html>