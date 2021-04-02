package pl.piomin.samples.security.gateway.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path of the request -> {}", exchange.getRequest().getPath());
		logger.info("Headers of the request -> {}", exchange.getRequest().getHeaders());
		System.out.println("Path of the request -> " + exchange.getRequest().getPath());
		System.out.println("Headers of the request -> " + exchange.getRequest().getHeaders());
		return chain.filter(exchange);
	}

}
