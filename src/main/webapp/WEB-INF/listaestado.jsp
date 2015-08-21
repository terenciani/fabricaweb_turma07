<%@page import="java.util.List"%>
<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Estado"%>
<%@page import="br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO"%>
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
			location.href = "estadocontroller.do?acao=alt&id=" + id;
		}
	};

	function excluir(id) {
		if (window.confirm("Deseja realmente excluir?")) {

			//Request GET
			location.href = "estadocontroller.do?acao=exc&id=" + id;
		}
	}
</script>

</head>
<body>

	<%@include file="menu.jsp"%>

	<a href="estadocontroller.do?acao=cad">Novo</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th>UF</th>
			<th>EDITAR</th>
		</tr>
		<%
			//Acessando dados do Servlet
			List<Estado> lista = (List<Estado>) request.getAttribute("listaEstado");
			//Gerando linhas na tabela para imprimir os dados
			for (Estado e : lista) {%>
		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getNome()%></td>
			<td><%=e.getUF()%></td>
			<td><a href="javascript:editar(<%=e.getId()%>)">Editar</a></td>
			<td><a href="javascript:excluir(<%=e.getId()%>)">Excluir</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>