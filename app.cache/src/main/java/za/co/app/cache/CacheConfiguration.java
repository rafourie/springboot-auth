package za.co.app.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CacheConfiguration {

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
