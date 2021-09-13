<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Cloths/updateCloths" method="post">
	<h2>Change Data for Cloth ID: <%=request.getParameter("cid")%></h2>
	<input type="hidden" name=cid value="<%=request.getParameter("cid")%>">
	<input type = "text" name = "name" value ="<%=request.getParameter("name")%>">
	<input type = "submit" value= "Update">

</form>

</body>
</html>