package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/autenticador.do")
public class Autenticador extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//criando objeto de busca
		
		Usuario usu = new Usuario();
		
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuAutenticado = usuarioDAO.autenticar(usu);		
		
		if (usuAutenticado != null){
			//Criando sessão
			
			HttpSession sessao = req.getSession();
			sessao.setMaxInactiveInterval(3600);
			sessao.setAttribute("usuAutenticado", usuAutenticado);
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		} else{
			//Redireciona para o login
			resp.sendRedirect("login.html");
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
		if (sessao != null){
			sessao.invalidate();
		}
		resp.sendRedirect("login.html");
	}
}
