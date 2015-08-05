package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

/**
 * Objeto de acesso a dados
 * @author terenciani
 *
 */

public class UsuarioDAO {
	private Connection conexao;
	
	public UsuarioDAO() {
		//Obtendo uma conexao com o banco
		conexao = ConexaoFactory.getConnection();
	}
	
	public void cadastrar(Usuario usuario){
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, md5(?))";
		
		//Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			//executando no banco
			preparador.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
