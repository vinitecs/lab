package br.com.lab.base;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.lab.security.UserSS;

@Component
public class BC {
	

	public static UserSS isAutenticated() {
	// buscar só ele mesmo 	
		try {
			
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
	}
	
	public Gson json() {
		return new Gson();
	}
}
