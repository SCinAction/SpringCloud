package com.example.hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/hello")
@Api(value = "Hello", tags = "Hello 资源")
public class HelloController {

	@Value("${greeting}")
	private String greeting;

	@GetMapping("")
	@ApiOperation(value = "查询 Hello")
	public String hello(@RequestHeader HttpHeaders headers) throws InterruptedException {
		log.info("headers: " + headers.toString());
		int sleepTime = new Random().nextInt(2000);
		log.info("Sleep Time: " + sleepTime);
		Thread.sleep(sleepTime);
		return "Hello, " + greeting;
	}
}
