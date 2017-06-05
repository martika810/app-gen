package com.madcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.madcoding")
@SpringBootApplication
public class App extends SpringBootServletInitializer{
	
    public static void main(String[] args){
	SpringApplication.run(App.class, args);
	
    }

}

