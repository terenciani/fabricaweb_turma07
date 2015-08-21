
<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Estado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function excluir() {
		if (window.confirm("Tem certezar que deseja excluir?")) {
			//Acessando o id preenchido no campo
			idDigitado = document.getElementById("id").value;
			//Request GET
			location.href = "estadocontroller.do?id=" + idDigitado;
		}
	}
</script>
</head>
<body>
	<%
		Estado estado = (Estado) request.getAttribute("estado");
	%>
	<form action="estadocontroller.do" method="POST">
		ID: <input type="text" name="id" id="id" value="<%=estado.getId()%>">
		Nome: <input type="text" name="nome" value="<%=estado.getNome()%>">
		UF: <input type="text" name="uf" value="<%=estado.getUF()%>">


		<input type="submit" value="Salvar"> <input type="button"
			value="Excluir" onclick="javascript:excluir()" />

	</form>
</body>
</html>