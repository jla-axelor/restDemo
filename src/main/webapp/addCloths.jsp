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
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
		function addCloths() {
			alert("Cloth added successfully !");
		}
	</script>
	<form action="../People/addPeopleCloths" method = "post">
	<h2>Enter Cloth for <%out.print(request.getAttribute("pid")); %></h2>
		 <input type="hidden"  name="pid" value="<%out.print(request.getAttribute("pid"));%>">
		<input type = "text" name = "cloth" placeholder = "Enter Cloth"><br>
		<input type = "submit" value = "Add Cloths" onclick = "addCloths()">
	</form>
</body>
</html>