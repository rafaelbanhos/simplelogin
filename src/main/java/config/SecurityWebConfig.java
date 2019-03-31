package config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // Para qualquer requisição (anyRequest) é preciso estar
                // autenticado (authenticated).
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws  Exception {
        builder
                .inMemoryAuthentication()
                .withUser("teste1").password("123")
                    .roles("USER")
                .and()
                .withUser("teste2").password("123")
                    .roles("USER");
    }


}
