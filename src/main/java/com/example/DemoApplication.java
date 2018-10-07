package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描MyBaties mapper包路径
@MapperScan(basePackages= "com.example.mapper")
//扫描所有需要的包，包含一些自用的工具类包  所在的路径
@ComponentScan(basePackages = {"com.example","org.n3r.idworker"})
@ServletComponentScan("com.example")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
