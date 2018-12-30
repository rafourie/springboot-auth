package za.co.app.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

  private static final Logger LOG = LoggerFactory.getLogger(CacheController.class);

  @Value("${spring.application.name}")
  private String name;
}
