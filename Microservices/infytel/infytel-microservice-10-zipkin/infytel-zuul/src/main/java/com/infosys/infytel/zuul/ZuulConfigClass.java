package com.infosys.infytel.zuul;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class ZuulConfigClass {

	@Bean
	public FallbackProvider zuulFallbackProvider() {
		return new FallbackProvider() {
			
			
			public String getRoute() {

				return null;
			}
			
			
			public ClientHttpResponse fallbackResponse(String s,Throwable e) {
			
				return new ClientHttpResponse() {
					
					
					public HttpHeaders getHeaders() {
						
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.TEXT_PLAIN);
						return headers;
					}
					
					
					public InputStream getBody() throws IOException {
					
						return new ByteArrayInputStream("Sorry. Something went wrong".getBytes());
					}
					
					
					public String getStatusText() throws IOException {
					
						return "OK";
					}
					
					
					public HttpStatus getStatusCode() throws IOException {
					
						return HttpStatus.OK;
					}
					
					
					public int getRawStatusCode() throws IOException {
						
						return 200;
					}
					
					
					public void close() {
						// Close method
						
					}
				};
			}
		};
	}
}
