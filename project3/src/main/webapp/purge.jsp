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
 <% String purgedShow=(String)request.getAttribute("theOne"); %>
 	The following show has been purged: <%=purgedShow%> <br><br>
 	
 	Please go back to the menu
  </div>

  <input type="submit" name=backToMain value="Main Menu">
  
 </form>
</body>
</html>