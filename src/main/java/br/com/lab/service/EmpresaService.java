package br.com.lab.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import com.google.gson.Gson;
import br.com.lab.base.BC;

@Path("/empresa")
public class EmpresaService extends BC{

	Gson gs = new Gson();
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String empresa() {
		
		
		return "";
	}
	
}
