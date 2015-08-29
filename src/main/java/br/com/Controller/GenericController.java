package br.com.Controller;

import java.util.ArrayList;
import java.util.List;

import br.com.Interface.IController;
import br.com.Util.Validacao;
import br.com.core.DAO.MsrDAO;
import br.com.core.Interface.IModel;
import br.com.core.Model.Empresa;
import br.com.core.Util.Mensagem;
import br.com.core.Util.Retorno;


public abstract class GenericController<Model> implements IController{

	protected abstract Retorno validar(IModel<?> imodel);
	MsrDAO dao = new MsrDAO();
	ArrayList<String> lstMensagens = new ArrayList<String>();
	

	public Retorno desativar(IModel<?> imodel) {
		return dao.desativar(imodel);
	}

	public List<IModel<?>> listar(IModel<?> imodel) {
		return dao.findAll(imodel);
	}
	
	public List<IModel<?>> listarCriterio(IModel<?> entidade, String parametro, boolean ativo) {
		return dao.findCriterio(entidade, parametro, ativo);
	}
	
	public Retorno salvar(IModel<?> imodel) {
		Retorno ret = validar(imodel);
		
		if(ret.isValid()){
			ret = dao.save(imodel);
			
		}
		return ret;
	}
	
	public Retorno alterar(IModel<?> imodel) {
		Retorno ret = validar(imodel);
		
		if(ret.isValid()){
			ret = dao.alterar(imodel);
			
		}
		return ret;
	}

	public Retorno ativar(IModel<?> imodel) {
		return dao.ativar(imodel);
	}
	
}
