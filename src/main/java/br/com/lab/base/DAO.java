package br.com.lab.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DAO {
	
	
	
	protected  MapSqlParameterSource parameters;
	
	@Autowired
	protected NamedParameterJdbcTemplate namedJdbcTemplate; 

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	abstract protected Object post(Bean bean);
	
	abstract protected Object insert(Bean bean); 
	
	abstract protected Object update(Bean bean);
	
	abstract protected Object getAll(Bean bean);
	
	abstract protected Object findById(Bean bean);
	
	abstract protected List<?> getByFilter(Bean bean); 
	
	abstract public Boolean remove(Bean object);  
	
	abstract protected void fillParameters(Bean object);
	
	

}
