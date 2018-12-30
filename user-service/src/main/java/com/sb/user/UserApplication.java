package com.sb.user;

/*import com.sb.user.dao.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;*/

/*import javax.sql.DataSource;*/

@SpringBootApplication
/*@EnableJpaRepositories("com.sb.user.dao")
@EntityScan("com.sb.user")*/
public class UserApplication implements CommandLineRunner {

  /*@Autowired
  DataSource dataSource;

  @Autowired
  SystemRepository systemRepository;*/

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    /*System.out.println("Our DataSource is = " + dataSource);
    Iterable<com.sb.user.model.System> systemlist = systemRepository.findAll();
    for(com.sb.user.model.System systemmodel : systemlist){
      System.out.println("Here is a system: " + systemmodel.toString());
    }*/
  }
}
