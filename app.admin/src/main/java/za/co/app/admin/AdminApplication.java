package za.co.app.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.app.admin.model.User;
import za.co.app.admin.repository.UserRepository;

@SpringBootApplication
public class AdminApplication implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(AdminApplication.class);
  }

  @Override
  public void run(String... args) {

    userRepository.deleteAll();

    // save a couple of users
    userRepository.save(new User("test1", "test1"));

    // fetch all users
    System.out.println("Customers found with findAll():");
    System.out.println("-------------------------------");
    for (User user : userRepository.findAll()) {
      System.out.println(user);
    }
    System.out.println();

    // fetch an individual customer
    System.out.println("Customer found with findByUsername('test1'):");
    System.out.println("--------------------------------");
    System.out.println(userRepository.findByUsername("test1"));
  }
}