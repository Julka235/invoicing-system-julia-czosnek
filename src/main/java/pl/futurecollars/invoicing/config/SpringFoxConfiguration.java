package pl.futurecollars.invoicing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfiguration {

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("pl.futurecollars"))
        .paths(PathSelectors.any())
        .build()
        .tags(
            new Tag("invoice controller", "Controller used to list / add / update / delete invoices"),
            new Tag("tax-controller", "Controller used to calculate taxes.")
        )
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .description("Application to menage invoices")
        .license("No license available - private ")
        .title("Invoicing system")
        .contact(
            new Contact("Julia Czosnek",
                "https://github.com/Julka235/invoicing-system-julia-czosnek",
                "julia.cz13@o2.pl"
            )
        )
        .build();
  }

}
