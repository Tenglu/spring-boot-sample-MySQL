package com.example.springbootsampleMySQL;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.*;
@RestController
public class HelloController {
	
	protected static Logger logger=LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping("/")
	public String helloworld(){
		logger.debug("test");
		return "Hello World";
	}
	
	@RequestMapping("/hello/{name}")
	public String helloName(@PathVariable String name){
		return "Hello "+name;
	}

}
