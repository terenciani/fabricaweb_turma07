<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%@include file="menu.jsp"%>

	<%
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuAutenticado");
	%>

	Bem vindo
	<%=usuario.getNome()%>!
</body>
</html>