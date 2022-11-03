package br.com.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lab.dao.UsuarioDAO;
import br.com.lab.dto.CredenciaisDTO;
import br.com.lab.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UsuarioDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		
		if(usuario == null) {
			/**
			 * execessão  da api
			 *
			 * */
		}
		
		
		CredenciaisDTO user  =(CredenciaisDTO) dao.Auth(usuario);
		
		return new UserSS(user.getId(),user.getUsuario(),user.getSenha(), user.getPerfis());
	}

}
