package com.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

	}
	
	/*
	 * @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
	 */
	//@LoadBalanced
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	 
	    return builder
	            .setConnectTimeout(Duration.ofMinutes(1))
	            .setReadTimeout(Duration.ofMinutes(1))
	            .build();
	}*/
	
	/*@Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(3000);
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(3000);

        return restTemplate;
    }*/

}
