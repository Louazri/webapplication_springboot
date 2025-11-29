package com.louazri.webapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        //  permitAll() do permit all requests inside the web application
        // denyAll() do deny all requests inside the web application

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers("/","/home" , "/login" , "/holidays" , "/contact" , "/saveMsg" , "/courses" , "/about" , "/assets/**")
                                .permitAll()
                                .requestMatchers("/dashboard").authenticated()
                                .anyRequest().authenticated() )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/logout?logout=true")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true) // MANDATORY: Explicitly clear the SecurityContext
                        .deleteCookies("JSESSIONID") // Delete the standard session cookie
                        .permitAll())
                .httpBasic(httpBasicAuth -> {});

        return http.build();
    }
   @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("oussama")
                .password("louazri")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER" , "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user , admin);
    }
}
