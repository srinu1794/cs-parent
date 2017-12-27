package com.capgemini.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@ComponentScan({"com.capgemini.serviceimpl","com.capgemini.config"})
@SpringBootApplication
public class OnlineShopingApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(OnlineShopingApplication.class, args);
	}
}
