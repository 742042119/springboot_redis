package com.entor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages={"com.entor.mapper"})
@EnableCaching//开启缓存
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
