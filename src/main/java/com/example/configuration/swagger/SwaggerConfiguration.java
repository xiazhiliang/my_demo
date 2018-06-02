package com.example.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public Docket productsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("merchandise")
                .apiInfo(apiInfo("1.0"))
                .select()
                .paths(PathSelectors.ant("/v1/**"))
                .build();
//                .globalOperationParameters(parameter("token"));
    }

    private ArrayList<Parameter> parameter(String name) {
        return newArrayList(new ParameterBuilder()
                .name(name)
                .description("Description of header")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build());
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Merchandise Product API")
                .description("This is the API for merchandise")
                .license("supply@keruyun.com")
                .version(version)
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
