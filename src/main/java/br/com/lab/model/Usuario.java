package br.com.lab.model;

import br.com.lab.base.Bean;
import br.com.lab.model.Enum.Perfil;


public class Usuario extends Bean {
	
	private String  usuario;
	private String  nome;
	private String  email;
	private String  senha;
	private Integer perfis;
	private Endereco endereco;
	
	public Usuario() {}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	public Perfil getPerfis() {
		return Perfil.toEnum(perfis);
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfis = perfil.getCod();
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	
	
	
	
	
	

}
