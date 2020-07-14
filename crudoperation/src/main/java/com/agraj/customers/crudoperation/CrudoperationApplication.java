package com.agraj.customers.crudoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan ({"com.server", "com.server.config"})
@EnableJpaRepositories ("com.server.repository")
public class CrudoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudoperationApplication.class, args);
	}

}
