package org.openapitools.api;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Bootstrap extends HttpServlet {


  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setHost("localhost:8080");
    beanConfig.setBasePath("/v1");
    beanConfig.setResourcePackage("org.openapitools");
    beanConfig.setScan(true);
    beanConfig.setSchemes(new String[]{"http,https"});
    beanConfig.setTitle("swagger test");
    beanConfig.setVersion("1.0.0");
    beanConfig.setPrettyPrint(true);

    Info info = new Info()
            .title("jothi dev Server")
            .description("Custom Generated annotations")
            .termsOfService("")
            .contact(new Contact()
                    .email(""))
            .license(new License()
                    .name("")
                    .url("http://unlicense.org"));

    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
