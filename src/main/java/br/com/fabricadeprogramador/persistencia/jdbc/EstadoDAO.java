package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;

public class EstadoDAO {
	private Connection conexao;

	public EstadoDAO() {
		//Obtendo uma conexao com o banco
		conexao = ConexaoFactory.getConnection();
	}

	public void salvar (Estado estado){
		if (estado.getId() == null || estado.getId() == 0){
			cadastrar (estado);
		}else{
			alterar (estado);
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
	
	public void alterar(Estado estado){
		String sql = "UPDATE estado SET nome=?, uf=? where = id=?";
		
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
}
