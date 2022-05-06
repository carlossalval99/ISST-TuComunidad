package es.upm.dit.isst.tfgapi.security;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
        DataSource ds;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(ds)
                .usersByUsernameQuery("select dni, clave, true AS enabled from vecino where dni=?")
                .authoritiesByUsernameQuery("select dni, authority from authorities where dni=?");
        }

        //PARA DAR PERMISOS PARA CONSULTAR H2, SINO ESTA BLOQUEADA
        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                .ignoring()
                .antMatchers("/h2-console/**");
        }

        /*@Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }*/

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http
                    .authorizeRequests()
                        .antMatchers("/css/**", "/img/**", "/index", "/", "/infos/**").permitAll()
                        .anyRequest().authenticated().and()
                    .formLogin().permitAll().and()
                    .logout().permitAll().and()
                    .httpBasic();
        }


    }


