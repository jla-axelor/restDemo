<%@page import="java.util.List"%>
<%@page import="com.axelor.db.People"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>

<style>
*{
	font-family: 'Verdana',sans-serif;
	text-align: center;
	
}
table {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid black;
  margin-left: auto;
  margin-right: auto;
}

th, td {
  text-align: left;
  padding: 8px;
  border: 1px solid black;
}
th{
	background-color: teal;
	color: white;
}

tr:nth-child(even) { border-bottom-width: 2px solid black}
</style>

</head>
<body>

	
	<script type="text/javascript">
		function addData() {
			var name = document.getElementById("name")
			alert("Data added successfully !");	
		}
	</script>
	<script>
		function deleteData() {
			window.confirm("Are you sure !");
		}
	</script>
	
	<form action="<%=request.getContextPath()%>/People/createPeople" method="post" style="text-align: center;">
		<h1>Add People</h1>
		<label for="name">Name:</label> <input type="text" name="name" id = "name"><br>
		<input type="submit" onclick = "addData()" value="submit">
	</form>
	<br>
	
	
	
	
		

	<h1>Display data</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>People Name</th>
			<th>Cloths</th>
			<th> Adding Cloths</th>
			<th> Update Data</th>
			<th> Delete Data</th>
		</tr>
		<c:forEach items="${list}" var="People">
				<tr>
			<td>
				${People.pid}
			</td>
			<td>
				${People.pname}
			</td>
			<td>
			<table><tr>
					<th> Cloth ID</th>
					<th> Cloth Name</th>
				</tr>
				<c:forEach items = "${People.cloths}" var="Cloths">
				<tr>
					<td>${Cloths.cid}</td>
					<td>${Cloths.cname}</td>
					<td><a href="../updateC.jsp?cid=${Cloths.cid}&name=${Cloths.cname}">Update</a></td>
					<td><a href="../Cloths/deleteCloths?cid=${Cloths.cid}">Delete</a></td>
				</tr>
				</c:forEach>
				</table>
			</td>
			<td><a href = "../addCloths.jsp?uid=${People.pid}">Add Cloths</a> </td>
			<td><a href="../updateP.jsp?uid=${People.pid}&name=${People.pname}">update</a></td>
			<td><a href="../People/deletePeople?uid=${People.pid}" class = "delete" onclick="deleteData()">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>