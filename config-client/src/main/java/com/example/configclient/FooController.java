package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class FooController {
	@Value("${foo:null}")
	private String foo;

	@RequestMapping("/foo")
	public String foo() {
		return this.foo;
	}

	@Value("${bar:null}")
	private String bar;

	@RequestMapping("/bar")
	public String bar() {
		return this.bar;
	}
}

