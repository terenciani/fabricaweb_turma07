package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO;

@WebServlet("/estadocontroller.do")
public class EstadoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String uf = req.getParameter("uf");
		String id = req.getParameter("id");

		Estado estado = new Estado();
		if (id != null) {
			estado.setId(Integer.parseInt(id));
		}
		estado.setNome(nome);
		estado.setUF(uf);

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.cadastrar(estado);

		resp.getWriter().print("Estado Salvo!");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("acao");
		
		EstadoDAO estadoDAO = new EstadoDAO();

		if (acao == null || acao.equals("list")) {
			List<Estado> lista = estadoDAO.buscarTodos();
			resp.getWriter().print(lista);
		} else {
			String id = req.getParameter("id");

			Estado estado = new Estado();
			if (id != null && id != "") {
				estado.setId(Integer.parseInt(id));

				estadoDAO.delete(estado);
				resp.getWriter().print("Estado Deletado!");
			} else {
				resp.getWriter().print("Estado não pode ser deletado!");
			}
		}

	}
}
