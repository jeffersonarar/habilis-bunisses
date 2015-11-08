package br.com.Controller;

import java.util.ArrayList;
import java.util.List;

import br.com.core.Enum.TipoMensagem;
import br.com.core.Interface.IModel;
import br.com.core.Model.Atividade;
import br.com.core.Model.AtividadesRealizadas;
import br.com.core.Model.Conteudo;
import br.com.core.Model.Disciplina;
import br.com.core.Model.Estagiario;
import br.com.core.Util.Retorno;

public class AtividadesRealizadasController extends
		GenericController<AtividadesRealizadas> {

	private AtividadesRealizadas AtividadesRealizadas = new AtividadesRealizadas();
	private List<?> lstAtividadesRealizadas;
	private List<?> lstEstagiarios;
	private List<?> lstConteudos;
	private List<?> lstAtividades;
	
	protected Retorno validar(IModel<?> imodel) {
		setAtividadesRealizadas((AtividadesRealizadas) imodel);
		Retorno ret = new Retorno(true);
		if(getAtividadesRealizadas().getConteudo() == null){
			lstMensagens.add("Campo conteúdo é obrigatório!");
		}
		if (getAtividadesRealizadas().getContratoEstagio() == null) {
			lstMensagens.add("Campo contrato é obrigatório!");
		}
		if(getAtividadesRealizadas().getAtividade() == null){
			lstMensagens.add("Campo atividade é obrigatório!");
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
	
	public List<?> listarDisciplinasComMaisAssociacao(String nomeDisciplina, String nomeMatriz){
		String sql = "select  count(c.disciplina_id) as qtd, d.*, d.id  from atividades_realizadas as at "
				+ "inner join conteudo c on c.id = at.conteudo_id "
				+ "inner join disciplina d on d.id = c.disciplina_id "
				+ "inner join matriz m on m.id = d.matriz_id "
				+ "group by c.disciplina_id, d.*, d.id "
				+ "order by qtd DESC ";
		
		lstAtividadesRealizadas = criadordeSql(sql, new Disciplina());
		setLstAtividadesRealizadas(lstAtividadesRealizadas);
		return lstAtividadesRealizadas; 
	}

	public List<?> listarConteudosComMaisAssociacao(long disciplina_id){
		String sql = "select c.*, COUNT(c.id) as qtd,  d.nome as d_nome from atividades_realizadas ar "
				+ "inner join conteudo c on c.id = ar.conteudo_id  "
				+ "inner join disciplina d on d.id = c.disciplina_id "
				+ "where d.id = " +  disciplina_id
				+ "  group by c.id, d.nome  order by qtd DESC";
		
		lstConteudos = criadordeSql(sql, new Conteudo());
		setLstConteudos(lstConteudos);
		return lstConteudos; 
	}

	
	public List<?> listarEstagiariosConteudos(long conteudo_id){
		String sql = "select e.*, COUNT(e.id)as qtd from atividades_realizadas ar "
				+ "inner join conteudo c on c.id = ar.conteudo_id "
				+ "inner join disciplina d on d.id = c.disciplina_id "
				+ "inner join contrato_estagio ce on ce.id = ar.contrato_estagio_id "
				+ "inner join estagiario e on e.id = ce.estagiario_id "
				+ "where c.id = " + conteudo_id
				+ " group by e.id order by qtd DESC";
		
		lstEstagiarios = criadordeSql(sql, new Estagiario());
		setLstEstagiarios(lstEstagiarios);
		return lstEstagiarios; 
	}

	public List<?> listarAtividadesEstagiarios(long atividade_id){
		String sql = "select e.*, COUNT(e.id) as qtd from atividades_realizadas ar "
				+ "inner join conteudo c on c.id = ar.conteudo_id "
				+ "inner join disciplina d on d.id = c.disciplina_id "
				+ "inner join atividade a on a.id = ar.atividade_id "
				+ "inner join contrato_estagio ce on ce.id = ar.contrato_estagio_id "
				+ "inner join estagiario e on e.id = ce.estagiario_id "
				+ "where a.id = " + atividade_id
				+ " group by e.id order by qtd DESC";
		
		lstEstagiarios= criadordeSql(sql, new Estagiario());
		setLstEstagiarios(lstEstagiarios);
		return lstEstagiarios; 
	}
	
	
	
	public List<?> listarAtividadesComMaisAssociacao(long disciplina_id){
		String sql = "select a.*, COUNT(a.id) as qtd, d.nome as d_nome from atividades_realizadas ar "
				+ "inner join conteudo c on c.id = ar.conteudo_id "
				+ "inner join disciplina d on d.id = c.disciplina_id "
				+ "inner join atividade a on a.id = ar.atividade_id "
				+ "where d.id = "+ disciplina_id
				+ "group by a.id, d.nome order by qtd DESC";
		
		lstAtividades = criadordeSql(sql, new Atividade());
		setLstAtividades(lstAtividades);
		return lstAtividades; 
	}

	public AtividadesRealizadas getAtividadesRealizadas() {
		return AtividadesRealizadas;
	}


	public void setAtividadesRealizadas(AtividadesRealizadas atividadesRealizadas) {
		AtividadesRealizadas = atividadesRealizadas;
	}

	public List<?> getLstAtividadesRealizadas() {
		return lstAtividadesRealizadas;
	}

	public void setLstAtividadesRealizadas(List<?> lstAtividadesRealizadas) {
		this.lstAtividadesRealizadas = lstAtividadesRealizadas;
	}

	public List<?> getLstEstagiarios() {
		return lstEstagiarios;
	}

	public void setLstEstagiarios(List<?> lstEstagiarios) {
		this.lstEstagiarios = lstEstagiarios;
	}

	public List<?> getLstConteudos() {
		return lstConteudos;
	}

	public void setLstConteudos(List<?> lstConteudos) {
		this.lstConteudos = lstConteudos;
	}

	public List<?> getLstAtividades() {
		return lstAtividades;
	}

	public void setLstAtividades(List<?> lstAtividades) {
		this.lstAtividades = lstAtividades;
	}

	

}
