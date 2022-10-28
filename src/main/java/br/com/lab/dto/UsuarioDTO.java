package br.com.lab.dto;

import br.com.lab.base.Bean;

public class UsuarioDTO extends Bean{
	
		public String email;
		public String usuario;
		public String senha;
		
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
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
		
		
}
