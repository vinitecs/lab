package br.com.lab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.SystemPropertyUtils;

import br.com.lab.base.Bean;
import br.com.lab.base.DAO;
import br.com.lab.dto.CredenciaisDTO;
import br.com.lab.model.Usuario;
import br.com.lab.model.Enum.Perfil;


@Repository
public class UsuarioDAO extends DAO{
	


	private final RowMapper<Usuario> rowMapper = new RowMapper<Usuario>(){
     

		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Usuario usr = new Usuario();
        	
        	usr.setId(rs.getInt("usuario_id"));
        	usr.setUsuario(rs.getString("usuario"));
        	usr.setEmail(rs.getString("email"));
        	usr.setDataCadastro(rs.getDate("dataCadastro"));
        	usr.setSenha(rs.getString("senha"));        	
        	usr.setEmail(rs.getString("email"));
        	usr.setEmpresaId(rs.getInt("empresa_id"));
        	usr.setPerfil(Perfil.toEnum(rs.getInt("perfil")));    
  
      	
        	return usr;
        }
	};
	
	private final RowMapper<CredenciaisDTO> authUser = new RowMapper<CredenciaisDTO>(){
		public CredenciaisDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        	CredenciaisDTO usr = new CredenciaisDTO();        	
        	usr.setId(rs.getInt("usuario_id"));
        	usr.setUsuario(rs.getString("usuario"));        	
        	usr.setSenha(rs.getString("senha")); 
        	usr.addPerfil(Perfil.toEnum(rs.getInt("perfil")));
        	 
        	return usr;
        }
	};


	@Override
	public Object post(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Object insert(Bean bean) {
		Usuario usr = (Usuario) bean;	
		
		String sql = " INSERT INTO USUARIO ( "
	             + " 	usuario "
	             + " 	, nome "
	             + " 	, email "
	             + " 	, senha "
	             + " 	, empresa_id "
	             + " 	, dataCadastro "
	             + " 	, perfil "
	             + " 	) "
	             + " VALUES ( "
	             + " 	  :usuario "
	             + " 	, :nome "
	             + " 	, :email "
	             + " 	, :senha "
	             + " 	, :empresa_id "
	             + " 	, :dataCadastro "
	             + " 	, :perfil "
	             + " 	) ";
		
				fillParameters(usr);
				System.out.println(sql);
		
		return  namedJdbcTemplate.update(sql, parameters);
	}

	@Override
	protected Object update(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getAll(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object findById(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<?> getByFilter(Bean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Bean object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillParameters(Bean object) {
		Usuario usr = (Usuario) object;		
		parameters = new MapSqlParameterSource();
		parameters.addValue("usuario", usr.getUsuario());
		parameters.addValue("nome", usr.getNome());
		parameters.addValue("email", usr.getEmail());
		parameters.addValue("senha", usr.getSenha());
		parameters.addValue("empresa_id", usr.getEmpresaId());
		parameters.addValue("dataCadastro", usr.getDataCadastro());		
		parameters.addValue("perfil",usr.getPerfis().getCod());
		
	}
	
	public Boolean getByUser(String usuario) {
		
		Usuario usr = new Usuario();
			String sql ="select * from usuario where usuario = ?" ;
			

			
			
			try {
				usr = (Usuario)	 jdbcTemplate.queryForObject(sql,rowMapper, usuario);
				if(usr != null) {
				return 	true;
				}				
			}catch (Exception e) {
				return false;
			}
			
			return false;
	}

	
	public CredenciaisDTO Auth(String obj) {		
			String sql = " select usuario_id, "
							+ "      usuario, "
							+ "        senha, "
							+ "       perfil  "
						    + " from usuario    "
					      	+ "where usuario = ?" ;
			
			return (CredenciaisDTO) jdbcTemplate.queryForObject(sql, authUser, obj);
	}
}
