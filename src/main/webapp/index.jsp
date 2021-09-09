<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="People/createPeople" method="post">
		<h1>Add People</h1>
		<label for="name">Name:</label> <input type="text" name="name"><br>
		<input type="submit" value="submit">
	</form>
	<br>
	<h2>Display People details</h2>
	<button>
		<a href="People/showPeople"> Display People</a>
	</button>
</body>
</html>