package br.com.Controller;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Categoria;
import br.com.core.Model.Categoria;
import br.com.core.Util.Retorno;



public class CategoriaController extends GenericController<Categoria> {

	private Categoria categoria = new Categoria(); 
	
	@Override
	protected Retorno validar(IModel<?> imodel) {
		setCategoria((Categoria) imodel);
		Retorno ret = new Retorno(true);
		if(validarNome(categoria, getCategoria().getNome()).size() > 0){
			lstMensagens.add("Nome já existente!");
		}else
		if(getCategoria().getNome() == null || getCategoria().getNome().equals("")){
			lstMensagens.add("Campo nome é obrigatório!");
		}else 
		if(!lstMensagens.isEmpty()){
			String novamsg = lstMensagens.toString().replaceAll(",", "\n");
			String msg = novamsg.replace("[", " ").replace("]", " ");
			ret = new Retorno(false, msg, TipoMensagem.AVISO);
		}else{
			ret = new Retorno(true);
		}
		return ret;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
