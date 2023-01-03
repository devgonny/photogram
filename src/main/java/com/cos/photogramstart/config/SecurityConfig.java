package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http); //기존의 모든 요청을 login으로 redirect
		
		http.csrf().disable(); //CSRF토근 검사 비활성화
		
		http.authorizeRequests()
				.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/")
				.authenticated()
				.anyRequest()
				.permitAll()
				.and()
				.formLogin()
				.loginPage("/auth/signin") //GET
				.loginProcessingUrl("/auth/signin") // POST ->스프링시큐리티가 로그인 프로세스 진행 
				.defaultSuccessUrl("/");
	}
}
