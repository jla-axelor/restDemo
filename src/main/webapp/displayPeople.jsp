<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import=" java.util.*" %>
   <%@page import =  "javax.servlet.*" %>
    <%@page import="java.util.List"%>
    <%@page import="com.axelor.db.People"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Display data</h1>
	<table>
	<tr>
	<th>ID</th>
	<th>People Name</th>
	
	</tr>
	<%  for(People p:  (List<People>)request.getAttribute("list")){ %>
	<tr>
	<td><% out.print(p.getPid()); %></td>
	<td><% out.print(p.getPname()); %></td>
		<td><a href="../People/updateselectedPeople?uid=<% out.print((p.getPid()));%>">update</a></td>
		<td><a href="../People/deletePeople?uid=<% out.print((p.getPid()));%>">Delete</a></td>
	</tr>
		<%}%>
	</table>
	<a href = "../index.jsp">Click here to Back to home</a>
</body>
</html>