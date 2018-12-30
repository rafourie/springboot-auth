package com.sb.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class, args);
  }

  @Override
  public void run(String... args) { }
}