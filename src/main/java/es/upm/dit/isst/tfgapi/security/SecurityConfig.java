package es.upm.dit.isst.tfgapi.security;




import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
@RequestMapping("http://localhost:8083")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        DataSource ds;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(ds)
                .usersByUsernameQuery("select dni, clave, true AS enabled from vecino where dni=?")
                .authoritiesByUsernameQuery("select dni, authority from authorities where dni=?");
        }


        /*@Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }*/

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                .antMatchers("/").authenticated()

                .antMatchers(HttpMethod.POST, "/reunions/**").hasRole("PRESIDENTE")
                .antMatchers(HttpMethod.PUT, "/reunions/**").hasRole("PRESIDENTE")
                .antMatchers(HttpMethod.DELETE, "/reunions/**").hasRole("PRESIDENTE")

                .antMatchers(HttpMethod.POST, "/votacions").hasRole("PRESIDENTE")
                .antMatchers(HttpMethod.PUT, "/votacions/**").hasRole("PRESIDENTE")
                .antMatchers(HttpMethod.DELETE, "/votacions/**").hasRole("PRESIDENTE")

                
                .antMatchers(HttpMethod.PUT, "/infos/**").hasRole("PRESIDENTE")
                .antMatchers(HttpMethod.DELETE, "/infos/**").hasRole("PRESIDENTE")


                //.antMatchers("/infos").hasAnyRole("PRESIDENTE", "VECINO")
                .antMatchers("/App.css", "/Home.css", "/index.css","/manifest.json").authenticated()
                .anyRequest().authenticated()   //Authenticated users can perform any other request not included above
            .and().formLogin().permitAll()  
            .and().logout().permitAll();
            http.cors().and().csrf().disable();

                       /* .antMatchers("/manifest.json").authenticated()
                        .antMatchers("/reunions/new","/infos/edit").hasRole("PRESIDENTE")
                        .anyRequest().authenticated().and()
                    .formLogin().permitAll().and()
                    .logout().permitAll().and()
                    .httpBasic();*/
              
                    
        }

        //PARA DAR PERMISOS PARA CONSULTAR H2, SINO ESTA BLOQUEADA
        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                .ignoring()
                .antMatchers("/h2-console/**");
        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    }


