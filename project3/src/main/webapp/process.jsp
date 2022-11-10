<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Netflix Top 10</title>
</head>
<style>
body{
background-image: url('netflix2.png');
}
</style>
<body style="background-color:black">
<form action=http://localhost:8082/project3/Project3Servlet method="get">

  <div style = "color:white; position:relative;">
  <% String selection=(String)request.getAttribute("showSelected"); %>
	Show selected: <%=selection%> <br><br>
	What would you like to do next? <br><br>
	
  <input type="submit" name=purge value="Purge Show">
  <input type="submit" name=suggest value="Get Suggestion">
  <input type="submit" name=backToMain value="Main Menu">
  </div>
</form>
</body>
</html>