package br.com.lab.base;

import java.util.Date;

public class Bean {

	private Integer id;
	private Date dataCadastro;
	private Integer empresa_id;
	
	
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
		return empresa_id;
	}
	
	public void setEmpresaId(Integer empresa_id) {
		this.empresa_id = empresa_id;
	}
	
	
	
}
