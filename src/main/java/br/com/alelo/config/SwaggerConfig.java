package br.com.alelo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 @Bean 
	 public Docket estacionamentoApi() {
		
		 return new Docket(DocumentationType.SWAGGER_2)
				 .useDefaultResponseMessages(false)
				 .select()
				 .apis(RequestHandlerSelectors.basePackage("br.com.alelo.controller"))
				 .paths(PathSelectors.any())
				 .build()
				 .apiInfo(apiInfo());
				 
				 
	 }
	
	 private ApiInfo apiInfo() {
		 return new ApiInfoBuilder()
				 .title("Teste Alelo")				 
				 .description("Projeto teste Alelo")
				 .version("1.0")
				 .build();
				 
	 }
	
   }
