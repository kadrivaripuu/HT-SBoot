package com.ht.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.ht.core.service"})
@EnableJpaRepositories(basePackages = "com.ht.core.dao")
@EntityScan( basePackages = {"com.ht.core.model"} )
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
public class HtCoreConfig {

}
