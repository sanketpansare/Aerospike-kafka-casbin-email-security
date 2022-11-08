package com.restapi;


import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@OpenAPIDefinition(
        info = @Info(
                title = "aerospike",
                version = "0.0",
                description = "Hrishi API",
                license = @License(name = "Apache 2.0", url = "https://hrishi.bar"),
                contact = @Contact(url = "https://gigantic-server.com", name = "Hrishikesh Nalavade", email = "hrishikeshnalavade22@gmail.com")
        )
)

public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
