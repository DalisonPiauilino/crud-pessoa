package com.crudpessoa.crudpessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {CrudPessoaApplication.class, Jsr310JpaConverters.class})
public class CrudPessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPessoaApplication.class, args);
	}

}
