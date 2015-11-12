package br.com.Controller;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Disciplina;
import br.com.core.Util.Retorno;


public class DisciplinaController extends GenericController<Disciplina> {

	private Disciplina disciplina = new Disciplina();
	
	@Override
	protected Retorno validar(IModel<?> imodel) {
		setDisciplina((Disciplina) imodel);
		Retorno ret = new Retorno();
		if(validarNome(disciplina, getDisciplina().getNome()).size() > 0){
			lstMensagens.add("Nome j� existente!");
		}
		if(getDisciplina().getMatriz() == null){
			lstMensagens.add("Campo matriz � o obrigat�rio!");
		}
		if(getDisciplina().getNome()== null || getDisciplina().getNome().equals("")){
			lstMensagens.add("Campo nome � obrigat�rio!");
		}
		if(getDisciplina().getCarga_horaria_total() == null || getDisciplina().getCarga_horaria_total().equals("")){
			lstMensagens.add("Campo carga hor�ria � obrigat�rio!");
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	

}
