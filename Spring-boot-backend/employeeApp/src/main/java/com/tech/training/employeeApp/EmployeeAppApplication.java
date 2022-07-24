package com.tech.training.employeeApp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan(basePackageClasses = EmployeeResourceController.class)
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}

	@Bean
    public CorsFilter corsFilter() {
         CorsConfiguration configuration = new CorsConfiguration();
         configuration.setAllowCredentials(true);
         configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
         configuration.setAllowedHeaders(Arrays.asList("Origin","Access-control-allow-origin",
        		 "Accept", "Authorization", "Cache-Control", "Content-Type",
        		 "X-Requested-With","Access-Control-Request-Methods",
        		 "Access-Control-Request-Headers"));
         configuration.setExposedHeaders(Arrays.asList("Origin","Access-control-allow-origin",
        		 "Accept", "Authorization", "Cache-Control", "Content-Type",
        		"Access-Control-Request-Methods",
        		 "Access-Control-Request-Headers"));
         
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new  CorsFilter(source);
}

}