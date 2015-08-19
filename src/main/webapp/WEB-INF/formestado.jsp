
<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Estado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Estado estado = (Estado) request.getAttribute("estado");
	%>
	<form action="estadocontroller.do" method="POST">
		ID: <input type="text" name="id" id="id" value="<%=estado.getId()%>">
		Nome: <input type="text" name="nome" value="<%=estado.getNome()%>">
		UF: <input type="text" name="uf" value="<%=estado.getUF()%>">


		<input type="submit" value="Salvar"> 
		<input type="button" value="Excluir" onclick="javascript:excluir()" />
	</form>
</body>
</html>