package com.ht.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ht.core.config.HtCoreConfig;

@SpringBootApplication
@Import(value = {HtCoreConfig.class})
public class HTApplication {
	public static void main(String[] args) {
		 SpringApplication.run(HTApplication.class, args);
	}
}
