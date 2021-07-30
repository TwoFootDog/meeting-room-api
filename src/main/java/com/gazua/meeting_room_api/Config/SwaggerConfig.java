package com.gazua.meeting_room_api.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    private final ServletContext servletContext;
//    private final String ROOT = "/meetingroom/api/v1";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .pathProvider(new PathProvider() {
//                    @Override
//                    public String getOperationPath(String operationPath) {
//                        return operationPath.replace(ROOT, "");
//                    }
//
//                    @Override
//                    public String getResourceListingPath(String groupName, String apiDeclaration) {
//                        return null;
//                    }
//                })
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("*/project/**"))
                .build().apiInfo(getApiInfo());
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars");
//    }

    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Meeting Room Service")
                .description("This Page Documents Project & Meeting Room Restful Web Service endpoints")
                .version("0.1")
                .build();
    }
}
