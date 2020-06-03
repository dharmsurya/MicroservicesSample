package io.suryacomp.onlinetrainings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineTrainingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTrainingsApplication.class, args);
	}

}
