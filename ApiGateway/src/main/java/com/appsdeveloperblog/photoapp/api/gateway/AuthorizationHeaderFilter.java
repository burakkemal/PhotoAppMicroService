package com.appsdeveloperblog.photoapp.api.gateway;



import javax.ws.rs.core.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory {
	
	@Autowired
	Environment environment;
	
	@Override
	public GatewayFilter apply(Object config) {
		return (exchange,chain)->{
			ServerHttpRequest request=exchange.getRequest();
			if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				return onError(exchange,"No Auth Header",HttpStatus.UNAUTHORIZED);
			}
			String authorizationHeader =request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			
			String jwt = authorizationHeader.replace("Bearer", "");
			
			if (!isJwtValid(jwt)) {
				return onError(exchange,"JWT is no valid",HttpStatus.UNAUTHORIZED);
			}
			return chain.filter(exchange);
		};	
	}
	private Mono<Void> onError(ServerWebExchange exchange, String error, HttpStatus httpStatus) {
		ServerHttpResponse response =exchange.getResponse();
		response.setStatusCode(httpStatus);
		return response.setComplete();
	}
	private boolean isJwtValid(String jwt) {
		boolean returnValue=true;
		
		String subject = Jwts.parser().setSigningKey(environment.getProperty("token.secret"))
		.parseClaimsJws(jwt)
		.getBody()
		.getSubject();
		
		if (subject==null || subject.isEmpty()) {
			return false;
		}
		return returnValue;
	}
}
