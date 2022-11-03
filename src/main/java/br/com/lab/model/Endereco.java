package br.com.lab.model;

public class Endereco  {
	
	private Integer enderecoId; 
	private String  cep;
	private String  logradouro;
	private String  bairro;
	private Integer Numero;
	private String  complemento;
	
	
	
	public Endereco(Integer enderecoId, String cep, String logradouro, String bairro, Integer numero,
			String complemento) {
		super();
		this.enderecoId = enderecoId;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.Numero = numero;
		this.complemento = complemento;
	}
	
	
	public Integer getEnderecoId() {
		return enderecoId;
	}
	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getNumero() {
		return Numero;
	}
	public void setNumero(Integer numero) {
		Numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
}
