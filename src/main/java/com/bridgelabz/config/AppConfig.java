package com.bridgelabz.config;

import org.springframework.core.env.Environment;

import com.bridgelabz.drivers.DataBaseDriver;
import com.bridgelabz.drivers.MySqlDriver;
import com.bridgelabz.drivers.OracleDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.bridgelabz")
@PropertySource("classpath:oracledb.properties")

public class AppConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	DataBaseDriver oracleDriver() {
		OracleDataBase oracleDriver = new OracleDataBase();
		oracleDriver.setDriver(environment.getProperty("db.driver"));
		oracleDriver.setUrl(environment.getProperty("db.url"));
		oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPassword(environment.getProperty("db.password"));

        return oracleDriver;
	}
	@Bean(name="sqlDriver")
	DataBaseDriver mysqlDriver() {
		MySqlDriver mysqlDriver = new MySqlDriver();
		return mysqlDriver;
	}
	
}
