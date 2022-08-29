package com.example.project.GUI;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);
    JTextField Register_IDField = new JTextField("Register ID");
    JLabel Register_IDLabel = new JLabel("Register ID", JLabel.CENTER);

    JTextField Register_nameField = new JTextField("Register name");
    JLabel Register_nameLabel = new JLabel("Register name", JLabel.CENTER);

    JTextField Register_addressField = new JTextField("Register address");
    JLabel Register_addressLabel = new JLabel("Register address", JLabel.CENTER);

    JTextField Register_emailField = new JTextField("Register email");
    JLabel Register_emailLabel = new JLabel("Register email", JLabel.CENTER);

    JTextField Register_passwordField = new JTextField("Register email");
    JLabel Register_passwordLabel = new JLabel("Register email", JLabel.CENTER);

    JTextField Course_NameField = new JTextField("Course Name");
    JLabel Course_NameLabel = new JLabel("Course Name", JLabel.CENTER);

    public RegisterView() {
        // -------------Editable Items------------------
        Register_IDField.setFont(mainFont);
        Register_IDLabel.setFont(mainFont);
        Register_nameField.setFont(mainFont);
        Register_nameLabel.setFont(mainFont);
        Register_addressField.setFont(mainFont);
        Register_addressLabel.setFont(mainFont);
        Register_emailField.setFont(mainFont);
        Register_emailLabel.setFont(mainFont);
        Register_passwordField.setFont(mainFont);
        Register_passwordLabel.setFont(mainFont);
        Course_NameField.setFont(mainFont);
        Course_NameLabel.setFont(mainFont);

        JPanel IDPanel = new JPanel();
        IDPanel.setLayout(new FlowLayout());
        IDPanel.add(Register_IDLabel);
        IDPanel.add(Register_IDField);

        JPanel NamePanel = new JPanel();
        NamePanel.setLayout(new FlowLayout());
        NamePanel.add(Register_nameLabel);
        NamePanel.add(Register_nameField);

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new FlowLayout());
        addressPanel.add(Register_addressLabel);
        addressPanel.add(Register_addressField);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout());
        emailPanel.add(Register_emailLabel);
        emailPanel.add(Register_emailField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(Register_passwordLabel);
        passwordPanel.add(Register_passwordField);

        JPanel Course_NamePanel = new JPanel();
        Course_NamePanel.setLayout(new FlowLayout());
        Course_NamePanel.add(Course_NameLabel);
        Course_NamePanel.add(Course_NameField);
        // -------------Combine all panels------------------
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(IDPanel);
        mainPanel.add(NamePanel);
        mainPanel.add(addressPanel);
        mainPanel.add(emailPanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(Course_NamePanel);

        // -------------Buttons------------------

        JButton editButton = new JButton("Confirm Edit");
        editButton.setFont(mainFont);
        editButton.addActionListener(arg0 -> {
            /* Add SQL code to see if the first and last names are inside the database */

        });
        JButton NextButton = new JButton("Next record");
        NextButton.setFont(mainFont);
        NextButton.addActionListener(arg0 -> {
            /* Add SQL code to see if the first and last names are inside the database */
        });
        JButton PreviousButton = new JButton("Previous record");
        PreviousButton.setFont(mainFont);
        PreviousButton.addActionListener(arg0 -> {
            /* Add SQL code to see if the first and last names are inside the database */
        });
        JButton DeleteButton = new JButton("Delete record");
        DeleteButton.setFont(mainFont);
        DeleteButton.addActionListener(arg0 -> {
            /* Add SQL code to see if the first and last names are inside the database */
        });
        JButton AddButton = new JButton("Add record");
        AddButton.setFont(mainFont);
        AddButton.addActionListener(arg0 -> {
            /* Add SQL code to see if the first and last names are inside the database */
        });
        JButton SearchButton = new JButton("Search record");
        SearchButton.setFont(mainFont);
        SearchButton.addActionListener(arg0 -> {
            /* Add SQL code to see if the first and last names are inside the database */
        });
        JButton MainMenuButton = new JButton("Main Menu");
        MainMenuButton.setFont(mainFont);
        MainMenuButton.addActionListener(arg0 -> {
            this.setVisible(false);
            new MainMenu().setVisible(true);
        });
        // -------------Center Layout------------------
        JPanel CenterPanel = new JPanel();
        CenterPanel.setLayout(new FlowLayout());
        CenterPanel.add(PreviousButton);
        CenterPanel.add(mainPanel);
        CenterPanel.add(NextButton);
        // -------------Center Buttons------------------
        JPanel CenterButtonsPanel = new JPanel();
        CenterButtonsPanel.setLayout(new FlowLayout());
        CenterButtonsPanel.add(editButton);
        CenterButtonsPanel.add(DeleteButton);
        CenterButtonsPanel.add(AddButton);
        // -------------Top Buttons------------------
        JPanel TopButtonsPanel = new JPanel();
        TopButtonsPanel.setLayout(new FlowLayout());
        TopButtonsPanel.add(SearchButton);
        TopButtonsPanel.add(MainMenuButton);

        // -------------Main Piece------------------
        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new FlowLayout());
        MainPanel.add(TopButtonsPanel);

        MainPanel.add(CenterPanel);

        MainPanel.add(CenterButtonsPanel);

        // -------------Frame------------------
        setTitle("Register");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(MainPanel);
        setVisible(true);

    }

}
