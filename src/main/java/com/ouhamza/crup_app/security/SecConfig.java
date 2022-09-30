package com.ouhamza.crup_app.security;

import com.ouhamza.crup_app.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author <a href="https://github.com/ouhamzalhss"> Lhouceine OUHAMZA </a>
 */

@Configuration
public class SecConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private CustomOAuth2UserService oAuth2UserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();

                auth.userDetailsService(userDetailsService)
                            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable();
        http.formLogin().loginPage("/login");
        http.authorizeRequests().antMatchers("/login",
                "/confirm-account/**",
                "/register/**",
                "/oauth/**",
                "/css**/**",
                "/resources**/**").permitAll();
        http.authorizeRequests().antMatchers("/new**/**","/edit**/**","/delete**/**");
        http.authorizeRequests().anyRequest().authenticated();

        http.oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(oAuth2UserService);

        http.exceptionHandling().accessDeniedPage("/403");

       // http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
