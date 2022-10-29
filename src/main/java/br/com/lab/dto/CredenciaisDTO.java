package br.com.lab.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.lab.base.Bean;
import br.com.lab.model.Enum.Perfil;

public class CredenciaisDTO extends Bean{
	
		
		private String usuario;
		private String senha;
		private Set<Integer> perfis = new HashSet<>();
		
		
		
	
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
	
		public Set<Perfil> getPerfis() {
			return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
		}
		
		public void addPerfil(Perfil perfil) {
			perfis.add(perfil.getCod());
		}
		
		
}
