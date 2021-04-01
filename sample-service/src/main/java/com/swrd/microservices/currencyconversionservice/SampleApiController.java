package com.swrd.microservices.currencyconversionservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleApiController {
	
	@GetMapping("/")
	public String sampleRootCall() {
		return "Root DATA";
	}

	@GetMapping("/data")
	public String sampleApiCall() {
		return "Some sample secured DATA";
	}

}
