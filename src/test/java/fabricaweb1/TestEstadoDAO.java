package fabricaweb1;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO;

public class TestEstadoDAO {
	public static void main(String[] args) {

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = new Estado();

		estado.setNome("Mato Grosso do Sul");
		estado.setUF("MS");

		Estado estado1 = new Estado();
		estado1.setNome("São Paulo");
		estado1.setUF("SP");

		Estado estado2 = new Estado();
		estado2.setNome("Mato Grosso");
		estado2.setUF("MT");

		estadoDAO.cadastrar(estado);
		estadoDAO.cadastrar(estado1);
		estadoDAO.cadastrar(estado2);

		System.out.println("Estado cadastrado com sucesso");

	}
}
