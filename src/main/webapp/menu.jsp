<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Menu</title>
</head>
<body>
	<nav id="menu">
	<ul>
		<li><a href="index.jsp">Home</a>
		<li><a href="aluno.jsp">Aluno</a>
		<li><a href="${pageContext.request.contextPath} /curso">Curso</a>
	</ul>
</nav>
</body>
</html>