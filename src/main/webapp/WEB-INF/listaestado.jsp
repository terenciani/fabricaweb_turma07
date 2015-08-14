<%@page import="java.util.List"%>
<%@page import="br.com.fabricadeprogramador.persistencia.entidade.Estado"%>
<%@page import="br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List <Estado> lista = (List <Estado>) request.getAttribute("listaEstado");
	
		for (Estado e : lista){
			out.print("<br> Estado: " + e.getNome());
		}
	%>
</body>
</html>