package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

/**
 * Objeto de acesso a dados
 * 
 * @author terenciani
 *
 */

public class UsuarioDAO {
	private Connection conexao;

	public UsuarioDAO() {
		// Obtendo uma conexao com o banco
		conexao = ConexaoFactory.getConnection();
	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() == null || usuario.getId() == 0) {
			cadastrar(usuario);
		} else {
			alterar(usuario);
		}

	}

	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, md5(?))";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			// executando no banco
			preparador.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		String sql = "UPDATE usuario SET nome=?, login=?, senha=? where id=?";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());

			// executando no banco
			preparador.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id=?";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setInt(1, usuario.getId());

			// executando no banco
			preparador.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> buscarTodos() {
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			// executando no banco
			ResultSet rs = preparador.executeQuery();
			Usuario usuario;
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public Usuario buscaPorId(Integer id) {
		String sql = "SELECT * FROM usuario WHERE id=?";
		Usuario usuario = null;

		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setInt(1, id);
			// executando no banco
			ResultSet rs = preparador.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;

	}

}
