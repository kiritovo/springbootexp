package com.ice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan 	
public class Springbootdemo21Application {
 
    //filter servlet listener 的除注解之外的配置方式见文件夹
	
	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo21Application.class, args);
	}
	
	

	
}
