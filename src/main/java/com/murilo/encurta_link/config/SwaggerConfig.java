package com.murilo.encurta_link.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("🚀 API Encurtador de URLs")
                        .description("💻 API simples para criar, listar e redirecionar URLs curtas\n\n👨‍💻 Desenvolvido por Murilo França de Sousa\n📧 murilofranca@example.com")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Murilo França de Sousa")
                                .email("murilofs.franca@gmail.com")));
    }
}
