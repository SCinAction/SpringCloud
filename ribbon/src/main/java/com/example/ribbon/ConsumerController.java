package com.example.ribbon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ConsumerController {
	@Autowired
	HelloService helloService;

	@RequestMapping(value = "/ribbon", method = RequestMethod.GET)
	public String helloConsumer(@RequestHeader HttpHeaders headers) {
		log.info("headers: " + headers.toString());
		return helloService.helloService();
	}
}
