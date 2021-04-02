package com.swrd.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		return builder.routes()
				.route(p -> p
						.path("/sample/**")
						.uri("lb://sample-service"))
				.route(p -> p
						.path("/api/**")
						.filters(f -> f.addResponseHeader(
								"/api/(?<segment>.*)",
								"/sample/${segment}"))
						.uri("lb://sample-service"))
				.build();
	}

}
