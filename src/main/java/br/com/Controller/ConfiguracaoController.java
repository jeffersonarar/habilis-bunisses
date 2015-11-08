package br.com.Controller;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Configuracao;
import br.com.core.Util.Retorno;

public class ConfiguracaoController extends GenericController<Configuracao> {

	private Configuracao configuracao = new Configuracao();
	
	
	
	@Override
	protected Retorno validar(IModel imodel) {
		Retorno ret = new Retorno();
		
		/*if(getConfiguracao().get == null){
			lstMensagens.add("Campo matriz é o obrigatório!");
		}
		if(getDisciplina().getNome()== null || getDisciplina().getNome().equals("")){
			lstMensagens.add("Campo nome é obrigatório!");
		}
		if(getDisciplina().getCarga_horaria_total() == null || getDisciplina().getCarga_horaria_total().equals("")){
			lstMensagens.add("Campo carga horária é obrigatório!");
		}
		if(!lstMensagens.isEmpty()){
			String novamsg = lstMensagens.toString().replaceAll(",", "\n");
			String msg = novamsg.replace("[", " ").replace("]", " ");
			ret = new Retorno(false, msg, TipoMensagem.AVISO);
		}else{
			ret = new Retorno(true);
		}*/
		ret = new Retorno(true);
		return ret;
	}



	public Configuracao getConfiguracao() {
		return configuracao;
	}



	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

}
