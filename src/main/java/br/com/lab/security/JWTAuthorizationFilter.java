package br.com.lab.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
	
	private UserDetailsService userDetailsService;
	private JWTUtil jwtUtil;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,JWTUtil jwtUtil, UserDetailsService userDetailsSetvice) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsSetvice;
	}
	 
	@Override
	protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		String header  = req.getHeader("Authorization");
		
		if(header !=  null  && header.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken auth = getAuthentication(req, header.substring(7));
			
			if(auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		
		
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req, String substring) {
		// TODO Auto-generated method stub
		return null;
	}
}
 	