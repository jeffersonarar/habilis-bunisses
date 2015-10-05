package br.com.Controller;

import br.com.Util.CorreioEletronico;
import br.com.Util.Helpers;
import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Estagiario;
import br.com.core.Util.Retorno;

public class EstagiarioController extends GenericController<Estagiario>{

	private Estagiario estagiario = new Estagiario();
	CorreioEletronico email = new CorreioEletronico();
	Helpers help = new Helpers();
	
	@Override
	protected Retorno validar(IModel<?> imodel) {
		setEstagiario((Estagiario) imodel);
		Retorno ret = new Retorno();
		
		if(getEstagiario().getNome()== null || getEstagiario().getNome().equals("")){
			lstMensagens.add("Campo nome é obrigatório!");
		}
		if(getEstagiario().getEmail() == null || getEstagiario().getEmail().equals("")){
			lstMensagens.add("Campo email é obrigatório!");
		}
		if(getEstagiario().getCpf()== null || getEstagiario().getCpf().equals("")){
			lstMensagens.add("Campo cpf é obrigatório!");
		}
		if(getEstagiario().getTelefone()==null || getEstagiario().getTelefone().equals("")){
			lstMensagens.add("Campo telefone é obrigatório!");
		}
		if(getEstagiario().getMatricula()==null|| getEstagiario().getMatricula().equals("")){
			lstMensagens.add("Campo matricula é obrigatório!");
		}
		if(getEstagiario().getMatriz() == null){
			lstMensagens.add("Campo matriz é o obrigatório!");
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
	
	public Retorno salvar(IModel<?> imodel) {
		setEstagiario((Estagiario) imodel); 
		String novaSenha = help.geradorDeSenha();
		getEstagiario().setSenha(help.criptografarBcripty(novaSenha));
		Retorno ret = new Retorno(false);
		ret = super.salvar(getEstagiario());	

		if(ret.isValid()){
			email.enviarEmailSimples((Estagiario) imodel, novaSenha);
		}
		return ret;
	}
	
	
	public IModel<?> validarLogin(IModel<?> entidade, String cpf, String senha){
		setEstagiario((Estagiario) entidade);
		return dao.buscarUsuario(estagiario, cpf, senha);
	}

	public Estagiario getEstagiario() {
		return estagiario;
	}

	public void setEstagiario(Estagiario estagiario) {
		this.estagiario = estagiario;
	}
	
	
	
}
