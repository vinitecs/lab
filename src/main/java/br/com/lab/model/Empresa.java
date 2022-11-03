package br.com.lab.model;

import javax.ws.rs.FormParam;

import br.com.lab.base.Bean;

public class Empresa extends Bean{
		
	
		@FormParam("empresaId")
		private Integer empresaId;
		
		@FormParam("razaoSocial")
		private String	razaoSocial;
		
		@FormParam("cnpj")
		private String  cnpj;
		
		@FormParam("nomeFantasia")
		private String  nomeFantasia;
		
		public Integer getEmpresaId() {
			return empresaId;
		}
		public void setEmpresaId(Integer empresaId) {
			this.empresaId = empresaId;
		}
		public String getRazaoSocial() {
			return razaoSocial;
		}
		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}
		public String getCnpj() {
			return cnpj;
		}
		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
		public String getNomeFantasia() {
			return nomeFantasia;
		}
		public void setNomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
		}
		
		
		
	
}
