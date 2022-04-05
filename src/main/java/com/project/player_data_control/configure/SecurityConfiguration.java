package com.project.player_data_control.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;
	public SecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}

    @Bean 
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
   
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }
	
    @Override
	protected void configure(HttpSecurity http) throws Exception{
    	
    	http
    	.authorizeRequests()
    	.antMatchers("/auth/login").permitAll()
    	.antMatchers("/auth/register").permitAll()
    	
		.antMatchers("/guns").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/bombs").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/armors").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/inventory").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/users").hasAnyAuthority("ADMIN")     
		.antMatchers("/users/**").hasAnyAuthority("USER","ADMIN") 
		
		.antMatchers(HttpMethod.POST , "/bombs").permitAll()
		.antMatchers(HttpMethod.POST , "/guns").permitAll()
		.antMatchers(HttpMethod.POST , "/armors").permitAll()
		
		.antMatchers(HttpMethod.PUT , "/bombs/**").permitAll()
		.antMatchers(HttpMethod.PUT , "/guns/**").permitAll()
		.antMatchers(HttpMethod.PUT , "/armors/**").permitAll()
		
		.antMatchers(HttpMethod.DELETE , "/bombs/**").permitAll()
		.antMatchers(HttpMethod.DELETE , "/guns/**").permitAll()
		.antMatchers(HttpMethod.DELETE , "/armors/**").permitAll()
		
		.antMatchers(HttpMethod.PUT , "/users/**").hasAnyAuthority("USER","ADMIN") 
		
		.anyRequest().permitAll()
		.and()
		.httpBasic();
		http.csrf().disable();
		http.formLogin();
	}

	
	
}
