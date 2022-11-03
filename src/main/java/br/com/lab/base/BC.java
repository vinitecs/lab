package br.com.lab.base;

import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
public class BC {
	
	
	
	public Gson json() {
		return new Gson();
	}
}
