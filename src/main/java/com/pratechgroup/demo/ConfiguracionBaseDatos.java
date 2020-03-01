package com.pratechgroup.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pratechgroup.demo.jpa.entidades.Customer;
import com.pratechgroup.demo.jpa.persistencia.CustomerRepository;
import com.pratechgroup.demo.jpa.persistencia.OperacionesUsuarioImpl;
import com.pratechgroup.demo.negocio.casosuso.OperacionesUsuario;

@Configuration
@ComponentScan(basePackageClasses = OperacionesUsuarioImpl.class)
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
@EntityScan(basePackageClasses = Customer.class)
public class ConfiguracionBaseDatos {

	private static final Logger log = LoggerFactory.getLogger(ConfiguracionBaseDatos.class);

	public ConfiguracionBaseDatos() {
		log.info("ConfiguracionBaseDatos INIT....");
	}

	@Bean
	public OperacionesUsuario taskOperations(CustomerRepository repository) {
		return new OperacionesUsuarioImpl(repository);
	}

}
