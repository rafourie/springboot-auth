package com.sb.auth;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path="/demo")
public class AuthController {

  private static final Logger log = LoggerFactory.getLogger(AuthController.class);

  private RestTemplate restTemplate;

  public AuthController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @PostMapping
  @HystrixCommand(fallbackMethod = "noOneHome")
  String echo(@RequestBody String message) {
    log.info("Sending echo message: {}", message);

    ResponseEntity<String> response = restTemplate
        .postForEntity("http://user-service/chamber", message, String.class);

    return response.getBody();
  }

  String noOneHome(String message) {
    log.warn("Hmm, looks like no one's home for echoing message [{}] :(", message);

    return message;
  }
}
