package za.co.app.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.app.admin.model.User;

@RestController
@RequestMapping("/admin")
public class AdminController {

  private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

  @Value("${spring.application.name}")
  private String name;

  @PostMapping
  String newUser(@RequestBody User user) {
    LOG.error("newUser: {}", user);
    return null;
  }
}
