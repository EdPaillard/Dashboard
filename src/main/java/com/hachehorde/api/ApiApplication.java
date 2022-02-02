package com.hachehorde.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.http.HttpStatus;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.web.AuthenticationEntryPoint;
// import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	// @Override
    // protected void configure(HttpSecurity http) throws Exception {
    	// @formatter:off
        // http
        //     .authorizeRequests(a -> a
        //         .antMatchers("/**", "/images/**", "/css/**", "/js/**", "/register", "/register/**", "/login", "/images/**").permitAll()
                
        //         .antMatchers("/home").authenticated()
        //     )
        //     .exceptionHandling(e -> e
        //         .authenticationEntryPoint((AuthenticationEntryPoint) new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        //     )
        //     .oauth2Login();
        // @formatter:on
        // http
        // .logout(l -> l
        //     .logoutSuccessUrl("/").permitAll()
        // );
    // @formatter:on
        // http
        //     .csrf(c -> c
        //         .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        //     );
    //}

}
