package com.redhat.consulting.route;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Routes  extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {		
	
		//SELECT 
		 from("timer://foo?fixedRate=true&period=1000")
		.toD("sql://SELECT * FROM SYS.PERSON?dataSource=#oracleDS")
		.log("### NUMBER OF RECORDS IN  THE TABLE PERSON : ${body.size}")
		
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {

				@SuppressWarnings("unchecked")
				List<Object> id =  exchange.getIn().getBody(List.class);
				Integer number = id.size()+1;
				String name = " Person " +number; 
				 
				exchange.getIn().setHeader("personId", number);
				exchange.getIn().setHeader("personName", name);
				
			}
		})
		
		.toD("sql://INSERT INTO SYS.PERSON (ID, NAME) VALUES (:#personId, :#personName)?dataSource=#oracleDS")
		.log("### INSERTED NEW RECORD IN THE TABLE PERSON ${header.personName}");

	}	
	
}
