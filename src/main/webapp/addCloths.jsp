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
	<form action="Cloths/addCloths" method = "post">
	<h2>Enter Cloth for <%=request.getParameter("uid")%></h2>
		 <input type="hidden"  name="pid" value="<%=request.getParameter("uid")%>">
		<input type = "text" name = "cloth" placeholder = "Enter Cloth"><br>
		<input type = "submit" value = "Add Cloths" onclick ="return alert('Cloth added successfully !')">
	</form>
	<br>
	<a href="<%=request.getContextPath()%>/People/showPeople">Back...!</a>
	
</body>
</html>