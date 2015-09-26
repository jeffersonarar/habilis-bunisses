package br.com.Controller;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Atividade;
import br.com.core.Util.Retorno;

public class AtividadeController extends GenericController<Atividade>{

	private Atividade atividade = new Atividade();
	
	@Override
	protected Retorno validar(IModel imodel) {
		setAtividade((Atividade) imodel);
		Retorno ret = new Retorno();
		if(getAtividade().getCategoria() == null){
			lstMensagens.add("Campo categoria é obrigatório!");
		}
		if(getAtividade().getNome()== null || getAtividade().getNome().equals("")){
			lstMensagens.add("Campo nome é obrigatório!");
		}
		if(!lstMensagens.isEmpty()){
			String novamsg = lstMensagens.toString().replaceAll(",", "\n");
			String msg = novamsg.replace("[", " ").replace("]", " ");
			ret = new Retorno(false, msg, TipoMensagem.AVISO);
		}else{
			ret = new Retorno(true);
		}
		return ret;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	

}
