package fabricaweb1;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {
	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Jão");
		usuario.setLogin("jjj");
		usuario.setSenha("12345");
		
		usuarioDAO.cadastrar(usuario);
		
		System.out.println("Cadastro realizado com sucesso");
		
		
	}
	
	
}
