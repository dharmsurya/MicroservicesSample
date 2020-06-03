package io.suryacomp.springbootquickstart;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class TopicCourseApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TopicCourseApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("io.suryacomp.springbootquickstart"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Topics and Courses API info",
				"Api for listing Topics and Courses",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("DSN","myurloremail","otherinfo"),
				"API license",
				"google.com",
				Collections.emptyList());
				
				
	}
}
