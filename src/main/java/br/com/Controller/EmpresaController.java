package br.com.Controller;

import java.util.List;

import br.com.Util.Validacao;
import br.com.core.DAO.MsrDAO;
import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Empresa;
import br.com.core.Util.Mensagem;
import br.com.core.Util.Retorno;

public class EmpresaController extends GenericController<Empresa> {
	
	private Empresa empresa = new Empresa();

	@Override
	protected Retorno validar(IModel<?> imodel) {
		setEmpresa((Empresa) imodel);
		Retorno ret = new Retorno(true);
		Validacao validacao = new Validacao();

		if(getEmpresa().getNome() == null || getEmpresa().getNome().equals("")){
			lstMensagens.add("Campo nome é obrigatório!");
		} 
		if(getEmpresa().getCnpj() == null || getEmpresa().getCnpj().equals("")){
			lstMensagens.add("Campo cnpj é obrigatório!");
		} 
		if(getEmpresa().getCnpj() != null){
			if (validacao.isCNPJ(getEmpresa().getCnpj().replace(".","").replace("/","").replace("-",""))  == false ){
				lstMensagens.add("CNPJ é inválido!");
			}
		}
		if(getEmpresa().getEmail() == null || getEmpresa().getEmail().equals("")){
			lstMensagens.add("Campo email é obrigatório!");
		}
		if(getEmpresa().getEmail() != null){
			if (validacao.isEmail(getEmpresa().getEmail())  == false ){
				lstMensagens.add("Email é inválido!");
			}
		}
		if(getEmpresa().getTelefone() == null || getEmpresa().getTelefone().equals("")){
			lstMensagens.add("Campo telefone é obrigatório!");
		} 
		if(getEmpresa().getCodigo_atividade_empresa() == null || getEmpresa().getCodigo_atividade_empresa().equals("")){
			lstMensagens.add("Campo codigo de atividade da empresa é obrigatório!");
		}
		
		if(getEmpresa().getId() == 0){
		if(dao.exists(getEmpresa(), getEmpresa().getCnpj()).isValid() == true ){
			lstMensagens.add("Empresa já existe!");
		}	
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	
}
