package za.co.app.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AdminConfiguration {

	@Bean
  RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
