package com.taskconnect.serviceprovider.cofig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "provedor de Serviços",
        description = "Serviços Para Encontrar Profissionais",
        version = "v1"
))
public class OpenApi3Config {

}

