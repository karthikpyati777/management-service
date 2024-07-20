package in.karthik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
//@EnableFeignClients
//@EnableDiscoveryClient
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Karthik Pyati",
						email = "karthik@gmail.com",
						url = "https://www.ja.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/karthikpyati777"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url = "https://www.javaguides.net/user_management.html"
		)
)
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
	
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}
}
