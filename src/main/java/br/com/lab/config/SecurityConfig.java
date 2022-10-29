package br.com.lab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import br.com.lab.security.JWTAuthenticationFilter;
import br.com.lab.security.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetaislService;
	
	private static String[] PUBLIC_MATCHERS = {
			"/**",
			"/rest/**"			
	};
	// criar configurações de parametros via GET
	private static String[] PUBLIC_MATCHERS_GET = {
					
	};
	@Autowired
	private JWTUtil jwtUtil;
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.cors().and().csrf().disable();
		http.authorizeHttpRequests()
		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(),jwtUtil));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	@Bean
	UrlBasedCorsConfigurationSource CorsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetaislService).passwordEncoder(bCryptPasswordEncoder());
	}
	@Bean 
	BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder(); 
	}
}
