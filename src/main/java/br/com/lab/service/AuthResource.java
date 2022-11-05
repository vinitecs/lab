package br.com.lab.service;



import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lab.base.BC;
import br.com.lab.security.JWTUtil;
import br.com.lab.security.UserSS;

@Path("/auth")
@Service
public class AuthResource extends BC{

	@Autowired
	JWTUtil jwt;
	
	@POST
	@Path("/refresh_token")
	@Produces({MediaType.APPLICATION_JSON})
	public ResponseEntity<Void> refrestToken(@Context  HttpServletResponse response){
		UserSS user = isAutenticated();
		String token = jwt.generateToken(user.getUsername());
		
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}
	
}
