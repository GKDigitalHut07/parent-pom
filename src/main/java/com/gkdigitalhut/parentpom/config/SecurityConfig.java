package com.gkdigitalhut.parentpom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	protected static final String[] EXCLUDE_PATH_MATHCHERS = { "/**" };

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults())
				.authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers(EXCLUDE_PATH_MATHCHERS)
						.permitAll().anyRequest().authenticated())
				.build();
	}
}
