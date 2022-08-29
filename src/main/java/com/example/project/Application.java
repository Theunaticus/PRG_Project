package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.project.GUI.*;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
<<<<<<< HEAD
    new MainController();
    System.setProperty("java.awt.headless", "false");
=======
    System.setProperty("java.awt.headless", "false"); //Disables headless
>>>>>>> 08ae2d546337ab6069bb0e03a6f95549420b3207
    SpringApplication.run(Application.class, args);
    MainFrame.main(args);
    //AdminView admin = new AdminView();
    //admin.setVisible(true);
  }

}
