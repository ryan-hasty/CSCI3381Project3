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
<%String myChosenWeek = (String)request.getAttribute("myChosenWeek");%><br>
<%String count = (String)request.getAttribute("count");%>
You chose the week:  <%=myChosenWeek%>.<br><br>
There are <%=count%> shows within the following week.<br><br><br>
Here they are!<br>
<label for="shows"><br></label>
<% String selection=(String)request.getAttribute("oneWeek"); %>
Choose a Show:<br><br><%=selection%><br><br><br>
	

  </div>
  <input type="submit" name=process value="Process Selected Show">
    <input type="submit" name=suggest value="Get Suggestion">
  <input type="submit" name=logout value="Logout">
</form>

</body>
</html>