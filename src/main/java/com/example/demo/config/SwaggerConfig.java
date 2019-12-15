package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile({"dev", "hom"})
@EnableSwagger2
public class SwaggerConfig {

//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;

//	@Autowired
//	private UserDetailsService userDetailsService;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
				.paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Ponto Inteligente API")
				.description("Documentação da API de acesso aos endpoints do Ponto Inteligente.").version("1.0")
				.build();
	}

//	@Bean
//	public SecurityConfiguration security() {
//		String token;
//		try {
//			UserDetails userDetails = this.userDetailsService.loadUserByUsername("admin@kazale.com");
//			token = this.jwtTokenUtil.obterToken(userDetails);
//		} catch (Exception e) {
//			token = "";
//		}
//
//		return new SecurityConfiguration(null, null, null, null, "Bearer " + token, ApiKeyVehicle.HEADER,
//				"Authorization", ",");
//	}

}
