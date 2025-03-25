package com.irojas.demojwt.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir recibir credenciales en las solicitudes
        config.setAllowCredentials(true);

        // Orígenes permitidos - ajusta según tu entorno
        config.addAllowedOrigin("https://despliegue-autenticacion.onrender.com"); // Frontend URL

        // Cabeceras permitidas
        config.addAllowedHeader("*");

        // Métodos permitidos
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
