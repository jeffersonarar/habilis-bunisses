package br.com.Util;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Helpers {
	
	public String geradorDeSenha(){
		UUID uuid = UUID.randomUUID();    
		String myRandom = uuid.toString();    
		System.out.println(myRandom.substring(0,6));
		return myRandom.substring(0,6);  
	}
	
	public String criptografarBcripty(String password){
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		return hashed;
	}

}
