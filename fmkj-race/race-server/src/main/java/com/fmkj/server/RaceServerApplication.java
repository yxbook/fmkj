package com.fmkj.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com"})//多包扫描
public class RaceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaceServerApplication.class, args);
	}
}
