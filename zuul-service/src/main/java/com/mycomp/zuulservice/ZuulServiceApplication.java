package com.mycomp.zuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
@EnableOAuth2Sso
/*
 * @EntityScan
 * 
 * @EnableJpaRepositories(
 * "com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.springdata.RateLimiterRepository")
 */
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}

	
	/*
	 * @Bean public RateLimiter springDataRateLimiter(final RateLimiterErrorHandler
	 * rateLimiterErrorHandler, final RateLimiterRepository rateLimiterRepository) {
	 * return new JpaRateLimiter(rateLimiterErrorHandler, rateLimiterRepository); }
	 */

    

}
