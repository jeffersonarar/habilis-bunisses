
package br.com.Controller;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.ContratoEstagio;
import br.com.core.Model.Estagiario;
import br.com.core.Util.Retorno;

public class ContratoEstagioController extends GenericController<ContratoEstagio>{
	
	private ContratoEstagio contrato = new ContratoEstagio();
		
	@Override
	protected Retorno validar(IModel<?> imodel) {
		setContrato((ContratoEstagio) imodel);
		Retorno ret = new Retorno();
		
		if(getContrato().getEstagiario() == null ){
			lstMensagens.add("Campo aluno � obrigat�rio!");
		}else if(getContrato().getEmpresa() == null){
			lstMensagens.add("Campo empresa � obrigat�rio!");
		}else if(getContrato().getCpf_supervisor() == null || getContrato().getCpf_supervisor().equals("")){
			lstMensagens.add("Campo cpf respons�vel � obrigat�rio!");
		}else if(getContrato().getNome_supervisor()==null || getContrato().getNome_supervisor().equals("")){
			lstMensagens.add("Campo nome respons�vel � obrigat�rio!");
		}else if(getContrato().getData_inicio()==null|| getContrato().getData_inicio().equals("")){
			lstMensagens.add("Campo data inicio � obrigat�rio!");
		}else if(getContrato().getData_fim() == null || getContrato().getData_fim().equals("")){
			lstMensagens.add("Campo data fim � o obrigat�rio!");
		}else if(getContrato().getEmail_supervisor() == null || getContrato().getEmail_supervisor().equals("")){
			lstMensagens.add("Campo email � o obrigat�rio!");
		}else if(getContrato().getData_inicio().after(getContrato().getData_fim())){
			lstMensagens.add("Data inicial inv�lida!");
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

	public ContratoEstagio getContrato() {
		return contrato;
	}

	public void setContrato(ContratoEstagio contrato) {
		this.contrato = contrato;
	}
	
}
