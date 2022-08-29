package GUI;

import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {
    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);

    JTextField student_IDField = new JTextField("Student ID");
    JLabel student_IDLabel = new JLabel("Student ID", JLabel.CENTER);

    JTextField student_nameField = new JTextField("Student name");
    JLabel student_nameLabel = new JLabel("Student name", JLabel.CENTER);

    JTextField student_addressField = new JTextField("Student address");
    JLabel student_addressLabel = new JLabel("Student address", JLabel.CENTER);

    JTextField student_emailField = new JTextField("Student email");
    JLabel student_emailLabel = new JLabel("Student email", JLabel.CENTER);

    JTextField student_passwordField = new JTextField("Student email");
    JLabel student_passwordLabel = new JLabel("Student email", JLabel.CENTER);

    public StudentView() {

        // -------------Editable Items------------------
        student_IDField.setFont(mainFont);
        student_IDLabel.setFont(mainFont);
        student_nameField.setFont(mainFont);
        student_nameLabel.setFont(mainFont);
        student_addressField.setFont(mainFont);
        student_addressLabel.setFont(mainFont);
        student_emailField.setFont(mainFont);
        student_emailLabel.setFont(mainFont);
        student_passwordField.setFont(mainFont);
        student_passwordLabel.setFont(mainFont);

        JPanel IDPanel = new JPanel();
        IDPanel.setLayout(new FlowLayout());
        IDPanel.add(student_IDLabel);
        IDPanel.add(student_IDField);

        JPanel NamePanel = new JPanel();
        NamePanel.setLayout(new FlowLayout());
        NamePanel.add(student_nameLabel);
        NamePanel.add(student_nameField);

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new FlowLayout());
        addressPanel.add(student_addressLabel);
        addressPanel.add(student_addressField);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout());
        emailPanel.add(student_emailLabel);
        emailPanel.add(student_emailField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(student_passwordLabel);
        passwordPanel.add(student_passwordField);
        // -------------Combine all panels------------------
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(IDPanel);
        mainPanel.add(NamePanel);
        mainPanel.add(addressPanel);
        mainPanel.add(emailPanel);
        mainPanel.add(passwordPanel);

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
        setTitle("Admin");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(MainPanel);
        setVisible(true);

    }

}
