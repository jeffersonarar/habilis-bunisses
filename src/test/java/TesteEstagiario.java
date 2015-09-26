

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.core.DAO.EstagiarioDAO;
import br.com.core.Enum.Periodo;
import br.com.core.Interface.IGenericDao;
import br.com.core.Interface.IModel;
import br.com.core.Model.Estagiario;
import br.com.core.Model.Matriz;

public class TesteEstagiario {
	
	
	public static void main(String[] args) {

		EstagiarioDAO estagiarioDao = new EstagiarioDAO();
		
		Estagiario estagiario = new Estagiario();
		Estagiario e[] = new Estagiario[5];
	
		e[4] = new Estagiario("NOME 4", "nome4@teste.com", "0627617-1616", 123567910, 11211111, true, "frft43t" ,true, new Matriz("2012", 5, true), 1);
		
		estagiarioDao.buscarUsuario(e[4], 314457910, "tgtgw");

	}

}
