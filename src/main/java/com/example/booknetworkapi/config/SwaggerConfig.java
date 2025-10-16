package com.example.booknetworkapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bookNetworkOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("📚 Book Network API")
                        .description("Secure API with JWT Authentication, Swagger UI, and MySQL")
                        .version("1.0.0"));
    }
}
