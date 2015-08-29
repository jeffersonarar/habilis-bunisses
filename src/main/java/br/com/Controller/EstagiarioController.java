package br.com.Controller;

import br.com.core.Interface.IModel;
import br.com.core.Model.Estagiario;
import br.com.core.Util.Retorno;

public class EstagiarioController extends GenericController<Estagiario>{

	private Estagiario estagiario = new Estagiario();
	
	@Override
	protected Retorno validar(IModel<?> imodel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Retorno validarLogin(IModel<?> entidade, int cpf, String senha){
		Retorno ret;
		setEstagiario((Estagiario) entidade);
		return ret = dao.buscarUsuario(estagiario, cpf, senha);
	}

	public Estagiario getEstagiario() {
		return estagiario;
	}

	public void setEstagiario(Estagiario estagiario) {
		this.estagiario = estagiario;
	}
	
	
	
}
