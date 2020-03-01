package com.pratechgroup.demo;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pratechgroup.demo.web.endpoints.ControllerUsuario;

@Configuration
@AutoConfigureBefore({ ValidationAutoConfiguration.class })
@ComponentScan(basePackageClasses = { ControllerUsuario.class })
public class ConfiguracionRest {

}
