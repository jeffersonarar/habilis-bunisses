package br.com.Util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.core.Model.Estagiario;
import br.com.core.Util.Retorno;

public class CorreioEletronico {
	
	String hostName = "smtp.mandrillapp.com";
	String authenticationUsername = "jeffersonarar@hotmail.com";
	String authenticationSenha = "lKuS1seNhNa5OjRoUTTRjQ";
	String toFrom = "jeffersonarar@hotmail.com";
	
	public Retorno enviarEmailSimples(Estagiario estagiario, String senha){
		Retorno ret = new Retorno(true);
		SimpleEmail email = new SimpleEmail();

		try {
			email.setDebug(true);
			email.setHostName(hostName);
			email.setAuthentication(authenticationUsername, authenticationSenha);
			email.setSSL(true);
			email.addTo(estagiario.getEmail());
			email.setFrom("jeffersonarar@hotmail.com");
			email.setSubject("Next - Senha de Cadastro");
			email.setMsg("Segue abaixo sua senha" + senha);
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
			return ret = new Retorno(false);
		}
		
		return ret;
		
	}
	

	
}
