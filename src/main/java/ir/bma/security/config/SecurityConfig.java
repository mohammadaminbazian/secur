package ir.bma.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/")
                                .permitAll()
                                .anyRequest().authenticated())
        .formLogin(
                formLogin -> formLogin
                        .loginPage("/login")
                        .usernameParameter("email")
                        .permitAll())
         .httpBasic(withDefaults());


        return http.build();
    }


   @Bean
    public UserDetailsService userDetailsService(DataSource dataSource, PasswordEncoder passwordEncoder){

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select  email, password, enabled from users where  email=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select  email,user_roles from authorities  where  email=?");
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
