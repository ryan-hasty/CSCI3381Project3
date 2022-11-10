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
  
<label for="shows">Choose a Week:<br></label>
<% String selectionList=(String)request.getAttribute("aShowList"); %>
<br><%=selectionList%><br> 

<%String showCT = (String)request.getAttribute("showCt");%><br><br>
There are <%=showCT%> shows in the library.

  </div>
  <input type="submit" name=seeShows value="See Shows">
  <input type="submit" name=logout value="Logout">
</form>

</body>
</html>