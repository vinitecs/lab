package br.com.lab.base;

import java.util.Date;

public class Bean {

	private Integer id;
	private Date dataCadastro;
	private Integer empresaId;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Integer getEmpresaId() {
		return empresaId;
	}
	
	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}
	
	
	
}
