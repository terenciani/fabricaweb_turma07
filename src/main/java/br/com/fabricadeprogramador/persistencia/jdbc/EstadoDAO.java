package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;

public class EstadoDAO {
	private Connection conexao;

	public EstadoDAO() {
		// Obtendo uma conexao com o banco
		conexao = ConexaoFactory.getConnection();
	}

	public void salvar(Estado estado) {
		if (estado.getId() == null || estado.getId() == 0) {
			cadastrar(estado);
		} else {
			alterar(estado);
		}
	}

	public void cadastrar(Estado estado) {
		String sql = "INSERT INTO estado (nome, uf) VALUES (?, ?)";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {

			preparador.setString(1, estado.getNome());
			preparador.setString(2, estado.getUF());

			// executando no banco
			preparador.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterar(Estado estado) {
		String sql = "UPDATE estado SET nome=?, uf=? where id=?";

		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {

			preparador.setString(1, estado.getNome());
			preparador.setString(2, estado.getUF());
			preparador.setInt(3, estado.getId());

			// executando no banco
			preparador.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(Estado estado) {
		String sql = "DELETE FROM estado WHERE id=?";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setInt(1, estado.getId());

			// executando no banco
			preparador.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Estado> buscarTodos() {
		List<Estado> estados = new ArrayList<Estado>();
		String sql = "SELECT * FROM estado";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			// executando no banco
			ResultSet rs = preparador.executeQuery();
			Estado estado;
			while (rs.next()) {
				estado = new Estado();
				estado.setId(rs.getInt("id"));
				estado.setUF(rs.getString("uf"));
				estado.setNome(rs.getString("nome"));
				estados.add(estado);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return estados;
	}

	public Estado buscaPorId(Integer id) {
		Estado estado = null;
		String sql = "SELECT * FROM estado WHERE id=?";

		// Criando objeto statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)) {
			preparador.setInt(1, id);
			// executando no banco
			ResultSet rs = preparador.executeQuery();

			while (rs.next()) {
				estado = new Estado();
				estado.setId(rs.getInt("id"));
				estado.setUF(rs.getString("uf"));
				estado.setNome(rs.getString("nome"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return estado;
	}

}
