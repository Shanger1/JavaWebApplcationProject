<%@page import="model.Player"%>
<%@page import="model.Team"%>
<%@page import="model.Statistics"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List</title>
</head>
<body>
<%
    Team team = (Team) session.getAttribute("team");
    Player player = (Player) session.getAttribute("player");
    Statistics statistics = (Statistics) session.getAttribute("statistics");
%>
<h1>Team:</h1>
<h2>Name:  <%=team.getName() %></h2>
<h2>Country:  <%=team.getCountry() %></h2>
<h1>Player:</h1>
<h2>Name:  <%=player.getName() %></h2>
<h2>Age:  <%=player.getAge() %></h2>
<h2>Country:  <%=player.getCountry() %></h2>
<h2>Team:  <%=player.getTeam() %></h2>
<h2>Experience:  <%=player.getExperience() %></h2>
<h1>Statistics:</h1>
<h2>Kills:  <%=statistics.getKills() %></h2>
<h2>Deaths:  <%=statistics.getDeaths() %></h2>
<form action="dbServlet" method="get">
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
