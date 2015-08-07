package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {

		Connection c=null;
		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/fabricaweb", "postgres","postgres");
		} catch (SQLException e) {
			//Wrapper de Exception
			throw new RuntimeException("não conectou!", e);
		}
		return c;
	}
}
