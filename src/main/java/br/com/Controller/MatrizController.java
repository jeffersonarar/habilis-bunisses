package br.com.Controller;

import br.com.core.Interface.IModel;
import br.com.core.Model.Matriz;
import br.com.core.Util.Retorno;

public class MatrizController extends GenericController<Matriz> {

	private Matriz matriz = new Matriz();
	
	@Override
	protected Retorno validar(IModel<?> imodel) {
		setMatriz((Matriz) imodel);
		Retorno ret = new Retorno(true);
		if(getMatriz().getNome() == null || getMatriz().getNome().equals("")){
			lstMensagens.add("Campo nome é obrigatório!");
		} 
		if(getMatriz().getQtd_periodo() == 0){
			lstMensagens.add("Número de periodos deve ser maior que zero!");
		} 
		return ret;
	}

	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

}
