package com.example.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class HelloController {

	@Value("${greeting}")
	private String greeting;

	@RequestMapping("/hello")
	public String hello(@RequestHeader HttpHeaders headers) throws InterruptedException {
		log.info("headers: " + headers.toString());
		int sleepTime = new Random().nextInt(2000);
		log.info("Sleep Time: " + sleepTime);
		Thread.sleep(sleepTime);
		return "Hello, " + greeting;
	}
}
