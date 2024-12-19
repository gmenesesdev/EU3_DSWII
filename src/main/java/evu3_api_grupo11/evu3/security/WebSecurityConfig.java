package evu3_api_grupo11.evu3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/estudiantes/practicas/**").permitAll() // Permitir acceso a todas las rutas de estudiantes
                .requestMatchers("/api/profesores/practicas/**").permitAll() // Permitir acceso a todas las rutas de profesores
            )
            .httpBasic(Customizer.withDefaults()) // Activar la autenticación básica, aunque no se usará en este caso
            .csrf(csrf -> csrf.disable()); // Desactivar CSRF para pruebas con Postman

        return http.build();
    }
}
