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

	<form action="People/updatePeople" method="post">
		<h2>Change Data for ID:  <%=request.getParameter("uid")%></h2>
		 <input type="hidden" name="id" value="<%=request.getParameter("uid")%>" readonly><br>
		
		<label for="name">Name:</label> <input type="text" name="name" value="<%=request.getParameter("name")%>"><br>
		
		<input type="submit" onclick= "updateData()" value="Update">
	</form><br>
	<a href="<%=request.getContextPath()%>/People/showPeople">Back...!</a>
	<script type="text/javascript">
		function updateData() {
			alert("Data has been Updated");
		}
	</script>
</body>
</html>