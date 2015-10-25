package br.com.Controller;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.AtividadesRealizadas;
import br.com.core.Util.Retorno;

public class AtividadesRealizadasController extends
		GenericController<AtividadesRealizadas> {

	private AtividadesRealizadas AtividadesRealizadas = new AtividadesRealizadas();

	
	protected Retorno validar(IModel<?> imodel) {
		setAtividadesRealizadas((AtividadesRealizadas) imodel);
		Retorno ret = new Retorno(true);
		if(getAtividadesRealizadas().getConteudo() == null){
			lstMensagens.add("Campo conte�do � obrigat�rio!");
		}
		if (getAtividadesRealizadas().getContratoEstagio() == null) {
			lstMensagens.add("Campo contrato � obrigat�rio!");
		}
		if(getAtividadesRealizadas().getAtividade() == null){
			lstMensagens.add("Campo atividade � obrigat�rio!");
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


	public AtividadesRealizadas getAtividadesRealizadas() {
		return AtividadesRealizadas;
	}


	public void setAtividadesRealizadas(AtividadesRealizadas atividadesRealizadas) {
		AtividadesRealizadas = atividadesRealizadas;
	}

}
