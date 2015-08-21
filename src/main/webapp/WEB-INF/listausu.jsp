<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">
	function editar(id) {
		if (window.confirm("Tem certezar que deseja editar?")) {
			//Request GET
			location.href = "usucontroller.do?acao=alt&id=" + id;
		}
	};
	
	function excluir(id) {
		if (window.confirm("Deseja realmente excluir?")) {
			
			//Request GET
			location.href = "usucontroller.do?acao=exc&id=" + id;
		}
	}
</script>
</head>
<body>

<%@include file="menu.jsp" %>
	
	<a href="usucontroller.do?acao=cad">Novo</a>
	<table border="1">

		
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>&nbsp; </th>
			<th>&nbsp; </th>
		</tr>
		<%
			//Acessando dados do Servlet
			List<Usuario> lista = (List<Usuario>) request.getAttribute("listaUsu");
			//Gerando linhas na tabela para imprimir os dados
			for (Usuario u : lista) {%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getNome()%></td>
			<td><a href="javascript:editar(<%=u.getId()%>)">Editar</a></td>
			<td><a href="javascript:excluir(<%=u.getId()%>)">Excluir</a></td>

		</tr>
		<%
			}
		%>
	</table>
</body>
</html>