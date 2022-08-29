package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.project.GUI.*;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    System.setProperty("java.awt.headless", "false"); //Disables headless
    SpringApplication.run(Application.class, args);
    MainFrame.main(args);
  }

}
