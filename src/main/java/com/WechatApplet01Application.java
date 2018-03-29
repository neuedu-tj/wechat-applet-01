package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //(exclude = {DataSourceAutoConfiguration.class})
public class WechatApplet01Application {

	public static void main(String[] args) {
		
	    SpringApplication.run(WechatApplet01Application.class, args);
	}
}
