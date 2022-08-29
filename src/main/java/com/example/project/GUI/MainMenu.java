package com.example.project.GUI;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);

    public MainMenu() {

        // -------------Buttons------------------
        JButton ExitButton = new JButton("Exit");
        ExitButton.setFont(mainFont);
        ExitButton.addActionListener(arg0 -> {
            Runtime.getRuntime().exit(0);
        });
        JButton AdminsButton = new JButton("View Admins");
        AdminsButton.setFont(mainFont);
        AdminsButton.addActionListener(arg0 -> {
            this.setVisible(false);
            AdminView adminsView = new AdminView();
            adminsView.setVisible(true);
        });
        JButton StudentsButton = new JButton("View Students");
        StudentsButton.setFont(mainFont);
        StudentsButton.addActionListener(arg0 -> {
            this.setVisible(false);
            StudentView students = new StudentView();
            students.setVisible(true);
        });
        JButton RegisterButton = new JButton("View Register");
        RegisterButton.setFont(mainFont);
        RegisterButton.addActionListener(arg0 -> {
            this.setVisible(false);
            RegisterView register = new RegisterView();
            register.setVisible(true);

        });

        // -------------Exit Panel------------------
        JPanel ExitPanel = new JPanel();
        ExitPanel.setLayout(new FlowLayout());
        ExitPanel.add(ExitButton);

        // -------------Navigation Panel------------------
        JPanel Navigation = new JPanel();
        Navigation.setLayout(new FlowLayout());
        Navigation.add(AdminsButton);
        Navigation.add(StudentsButton);
        Navigation.add(RegisterButton);

        // ----------------Main Panel------------------
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(Navigation);
        mainPanel.add(ExitPanel);
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setFont(mainFont);

        setTitle("Main Menu");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel);
        setVisible(true);

    }

}
