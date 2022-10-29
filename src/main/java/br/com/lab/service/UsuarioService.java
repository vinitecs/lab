package br.com.lab.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.lab.base.BC;
import br.com.lab.base.Bean;
import br.com.lab.dao.UsuarioDAO;
import br.com.lab.model.Usuario;
import br.com.lab.model.Enum.Perfil;

@Service
@Path("/usr")
@RequestMapping
public class UsuarioService extends BC {
	
	
	@Autowired	
	UsuarioDAO dao;	
	Gson gs = new Gson();
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})	
	@Path("/insert")
	public String login(@FormParam("usuario") String usuario,
						@FormParam("nome") String nome,
						@FormParam("email") String email,
						@FormParam("senha") String senha,
						@FormParam("dataCadastro") String dataCadastro,
						@FormParam("empresaId") Integer empresaId,
						@FormParam("perfil") Integer perfil) throws ParseException {
		
		
	    Date dateInicial = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataCadastro);	
		Usuario user = new Usuario();
		user.setUsuario(usuario);
		user.setNome(nome);
		user.setEmail(email);
		user.setSenha(bc.encode(senha));
		user.setDataCadastro(dateInicial);
		user.setEmail(email);
		user.setEmpresaId(empresaId);
		user.setPerfil(Perfil.toEnum(perfil));
	
		return gs.toJson(dao.insert(user)) ;
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/search")
	public String search(@QueryParam("usuario") String usuario) {		
		return gs.toJson(dao.getByUser(usuario));
	} 
	
	
	
}
