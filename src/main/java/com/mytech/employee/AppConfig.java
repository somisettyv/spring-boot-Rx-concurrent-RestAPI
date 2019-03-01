package com.mytech.employee;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.mytech")
//@PropertySource("classpath:database.properties")
public class AppConfig {

	@Autowired
	Environment environment;

/*
	private final String URL = "jdbc:h2:file:~/test;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1";
	private final String USER = "sa";
	private final String DRIVER = "org.h2.Driver";
	private final String PASSWORD = "";*/
	
	
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";

	/*
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
	
	@ConfigurationProperties(prefix = DataSourceAutoConfiguration.CONFIGURATION_PREFIX)
	@Bean
	public DataSource dataSource() {
	    DataSourceBuilder factory = DataSourceBuilder
	            .create(this.properties.getClassLoader())
	            .driverClassName(this.properties.getDriverClassName())
	            .url(this.properties.getUrl())
	            .username(this.properties.getUsername())
	            .password(this.properties.getPassword());
	    return factory.build();
	}*/
}


