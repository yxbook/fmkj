package com.fmkj.race.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SpringCloudApplication
@ComponentScan(basePackages = "com.fmkj")
@MapperScan("com.fmkj.race.dao.*")
public class RaceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaceServerApplication.class, args);
	}
}
