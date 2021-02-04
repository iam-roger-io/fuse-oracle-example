package com.redhat.consulting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@ConfigurationProperties
@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
@ComponentScan("com.redhat.consulting.*")
public class Application {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	
    public static void main(String[] args) {
    	   SpringApplication.run(Application.class, args);
   

        LOGGER.info("### :: Started :-) ");
        
    }
    

    

    
  

  
}
