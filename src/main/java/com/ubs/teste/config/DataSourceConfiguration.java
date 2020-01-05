package com.ubs.teste.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfiguration {

	@Value("${driverClassName}")
	private String DriverClassName;

	@Value("${SQLite.url}")
	private String URL;

	@Value("${username}")
	private String Username;

	@Value("${password}")
	private String Password;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.DriverClassName);
		dataSource.setUrl(this.URL);
		dataSource.setUsername(this.Username);
		dataSource.setPassword(this.Password);
		return dataSource;
	}
}
