package fabricaweb1;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestBuscaPorId {
	
	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioRetorno = usuarioDAO.buscaPorId(1);
		
		if (usuarioRetorno != null){
			System.out.println(usuarioRetorno.toString());
		}
	}
	
}
