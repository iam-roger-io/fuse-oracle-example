package com.redhat.consulting.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
@ConfigurationProperties
public class OracleDataSource  {

	@Value("${db.oracle.url}")
	private String DB_URL;

	@Value("${db.oracle.username}")
	private String DB_USERNAME;
	
	@Value("${db.oracle.password}")
	private String DB_PASSWORD;
		
	@Bean(name = "oracleDS")
	public DataSource dataSource() {		
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(this.DB_URL);
		dataSource.setUsername(this.DB_USERNAME);
		dataSource.setPassword(this.DB_PASSWORD);
		return dataSource;
	
	}
}
