package com.example.project.GUI;

import javax.swing.JFrame;

import com.example.project.Student;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {
    static Student[] AdminArray = new Student[40];
    static int Position = 0;


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




    public void DeleteMember(){
        Administrator[] AdminArrayReplacement = new Administrator[AdminArray.length-1];
        AdminArray[Position] = null;
        
        for (int i = 0; i < AdminArray.length; i++) {
            if  (AdminArray[i] != null) {
                AdminArrayReplacement[i] = AdminArray[i];
            }
            AdminArrayReplacement[i] = AdminArray[i];
        }
        AdminArray = AdminArrayReplacement;


    }

    public void ReplaceInfo(){
        AdminArray[Position].SetId( Integer.parseInt(Admin_IDField.getText()) );
        AdminArray[Position].SetName(Admin_nameField.getText());
        AdminArray[Position].SetPassword(Admin_PasswordField.getText());
        AdminArray[Position].SetContact(Admin_ContactField.getText());
    }

    public void AddNewAdmin(){
        try {
            MainController controller = new MainController();
            controller.addNewAdmin( Admin_nameField.getText(), Admin_PasswordField.getText(), Admin_ContactField.getText());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            AddFakeMember();
        } 
        
    }

    void AddFakeMember(){
        Administrator[] AdminArrayReplacement = new Administrator[AdminArray.length+1];
        Administrator admin = new Administrator();
        admin.SetId(Integer.parseInt( Admin_IDField.getText()) );
        admin.SetName(Admin_nameField.getText());
        admin.SetPassword(Admin_PasswordField.getText());
        admin.SetContact(Admin_ContactField.getText());
        for (int i = 0; i < AdminArray.length; i++) {
            AdminArrayReplacement[i] = AdminArray[i];
        }
        AdminArrayReplacement[AdminArray.length] = admin;
        AdminArray = AdminArrayReplacement;
    }

    public void MoveToRecord(int num){
        if (AdminArray.length > 0) {
            Position += num;
            if (Position < 0) {
                Position = AdminArray.length - 1;
                while(AdminArray[Position] == null){
                    Position--;
                }
            }else if(Position>=AdminArray.length-1){
                Position = 0;
            }
            QuickTextSet(Position);
        }
    }

    public void DisplayFirstRecord() {
        //a for each loop using the iterable AdminList
        //set the text fields to the first record in the list
        MainController mainController = new MainController();
        try {
            Iterable<Administrator> AdminList = mainController.getAllAdmins();
            
            int count = 0;
            if(AdminArray.length<=0){
                System.out.println("No records");
                GenerateFakeValues();
            }else{
                for (Administrator admin : AdminList) {
                    AdminArray[count] = admin;
                    count++;
                }
                QuickTextSet(0);

            }
        } catch (NullPointerException e) {
            GenerateFakeValues();
        }
        
        
            
    }

    void GenerateFakeValues(){
        AdminArray = new Administrator[5];
        Administrator admin = new Administrator();
        admin.SetId(1);
        admin.SetName("Admin");
        admin.SetPassword("Admin");
        admin.SetContact("Admin");
        AdminArray[0] = admin;
        Administrator admin1 = new Administrator();
        admin1.SetId(2);
        admin1.SetName("James");
        admin1.SetPassword("Parley");
        admin1.SetContact("Admin");
        AdminArray[1] = admin1;
        Administrator admin2 = new Administrator();
        admin2.SetId(3);
        admin2.SetName("Jonathan");
        admin2.SetPassword("steel");
        admin2.SetContact("Admin");
        AdminArray[2] = admin2;
        Administrator admin3 = new Administrator();
        admin3.SetId(4);
        admin3.SetName("Avery");
        admin3.SetPassword("12345");
        admin3.SetContact("Admin");
        AdminArray[3] = admin3;
        Administrator admin4 = new Administrator();
        admin4.SetId(5);
        admin4.SetName("King");
        admin4.SetPassword("Of The wordl");
        admin4.SetContact("Admin");
        AdminArray[4] = admin4;

        QuickTextSet(0);
    }

    public static void QuickTextSet(int num){

}
