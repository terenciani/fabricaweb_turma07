package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		String id = req.getParameter("id");

		// Instanciando o objeto usuario
		Usuario usuario = new Usuario();
		if (id != null && id !="") {
			usuario.setId(Integer.parseInt(id));
		}

		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		// Persistindo no banco
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.salvar(usuario);

		// Resposta
		resp.getWriter().print("Usuario Salvo!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		Usuario usuario = new Usuario();
		if (id != null && id != "") {
			usuario.setId(Integer.parseInt(id));

			UsuarioDAO usuarioDAO = new UsuarioDAO();

			usuarioDAO.delete(usuario);
			resp.getWriter().print("Usuario Deletado!");
		}else{
			resp.getWriter().print("Usuario não pode ser deletado!");
		}
	}
}
