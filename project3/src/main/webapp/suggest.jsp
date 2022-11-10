<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request</title>
</head>
<style>
body{
background-image: url('netflix2.png');
}
</style>
<body style="background-color:black">
<form action=http://localhost:8082/project3/Project3Servlet method="get">

  <div style = "color:white; position:relative;">
    <% String selection=(String)request.getAttribute("myRandom"); %>
	Random Show: <%=selection%> <br><br>
  </div>
    <input type="submit" name=suggest value="Get Another Suggestion">
  <input type="submit" name=backToMain value="Main Menu">
  
 </form>
</body>
</html>