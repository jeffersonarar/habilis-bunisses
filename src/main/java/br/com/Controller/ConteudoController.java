package br.com.Controller;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Conteudo;
import br.com.core.Util.Retorno;

public class ConteudoController extends GenericController<Conteudo> {

	private Conteudo conteudo = new Conteudo();

	@Override
	protected Retorno validar(IModel imodel) {
		setConteudo((Conteudo) imodel);
		Retorno ret = new Retorno(true);

		if (getConteudo().getNome() == null
				|| getConteudo().getNome().equals("")) {
			lstMensagens.add("Campo nome é obrigatório!");
		}
		if (getConteudo().getDisciplina() == null) {
			lstMensagens.add("Campo disciplina é obrigatório!");
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

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
}
