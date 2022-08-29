package com.example.project.GUI;

import javax.swing.JFrame;

import com.example.project.*;


import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class AdminView extends JFrame {
     
    
    static Administrator[] AdminArray = new Administrator[40];
    static int Position = 0;

    final private Font mainFont = new Font("Admin ID", Font.PLAIN, 20);
    static JTextField Admin_IDField = new JTextField("Admin ID");
    JLabel Admin_IDLabel = new JLabel("Admin ID", JLabel.CENTER);

    static JTextField Admin_nameField = new JTextField("Admin name");
    JLabel Admin_nameLabel = new JLabel("Admin name", JLabel.CENTER);

    static JTextField Admin_PasswordField = new JTextField("Admin Password");
    JLabel Admin_PasswordLabel = new JLabel("Admin Password", JLabel.CENTER);

    static JTextField Admin_ContactField = new JTextField("Admin Contact");
    JLabel Admin_ContactLabel = new JLabel("Admin Contact", JLabel.CENTER);

    public AdminView() {
        DisplayFirstRecord();
        // -------------Editable Items------------------
        Admin_IDField.setFont(mainFont);
        Admin_IDLabel.setFont(mainFont);
        Admin_nameField.setFont(mainFont);
        Admin_nameLabel.setFont(mainFont);
        Admin_PasswordField.setFont(mainFont);
        Admin_PasswordLabel.setFont(mainFont);
        Admin_ContactField.setFont(mainFont);
        Admin_ContactLabel.setFont(mainFont);

        JPanel IDPanel = new JPanel();
        IDPanel.setLayout(new FlowLayout());
        IDPanel.add(Admin_IDLabel);
        IDPanel.add(Admin_IDField);

        JPanel NamePanel = new JPanel();
        NamePanel.setLayout(new FlowLayout());
        NamePanel.add(Admin_nameLabel);
        NamePanel.add(Admin_nameField);

        JPanel PasswordPanel = new JPanel();
        PasswordPanel.setLayout(new FlowLayout());
        PasswordPanel.add(Admin_PasswordLabel);
        PasswordPanel.add(Admin_PasswordField);

        JPanel ContactPanel = new JPanel();
        ContactPanel.setLayout(new FlowLayout());
        ContactPanel.add(Admin_ContactLabel);
        ContactPanel.add(Admin_ContactField);

        // -------------Combine all panels------------------
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(IDPanel);
        mainPanel.add(NamePanel);
        mainPanel.add(PasswordPanel);
        mainPanel.add(ContactPanel);

        // -------------Buttons------------------

        JButton editButton = new JButton("Confirm Edit");
        editButton.setFont(mainFont);
        editButton.addActionListener(arg0 -> {
            /* Add SQL code to see if the first and last names are inside the database */
        });
        JButton NextButton = new JButton("Next record");
        NextButton.setFont(mainFont);
        NextButton.addActionListener(arg0 -> {
            MoveToRecord(1);
        });
        JButton PreviousButton = new JButton("Previous record");
        PreviousButton.setFont(mainFont);
        PreviousButton.addActionListener(arg0 -> {
            MoveToRecord(-1);
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
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(MainPanel);
        setVisible(true);

    }

    public void AddNewAdmin(){
        MainController controller = new MainController();
        controller.addNewAdmin( Admin_nameField.getText(), Admin_PasswordField.getText(), Admin_ContactField.getText());
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
        AdminArray = new Administrator[40];
        Administrator admin = new Administrator();
        admin.SetId(1);
        admin.SetName("Admin");
        admin.SetPassword("Admin");
        admin.SetContact("Admin");
        AdminArray[0] = admin;
        Administrator admin1 = new Administrator();
        admin.SetId(2);
        admin.SetName("James");
        admin.SetPassword("Parley");
        admin.SetContact("Admin");
        AdminArray[1] = admin1;
        Administrator admin2 = new Administrator();
        admin.SetId(3);
        admin.SetName("Jonathan");
        admin.SetPassword("steel");
        admin.SetContact("Admin");
        AdminArray[2] = admin2;
        Administrator admin3 = new Administrator();
        admin.SetId(4);
        admin.SetName("Avery");
        admin.SetPassword("12345");
        admin.SetContact("Admin");
        AdminArray[3] = admin3;
        Administrator admin4 = new Administrator();
        admin.SetId(5);
        admin.SetName("King");
        admin.SetPassword("Of The wordl");
        admin.SetContact("Admin");
        AdminArray[4] = admin4;

        QuickTextSet(0);
    }

    public static void QuickTextSet(int num){
        Admin_IDField.setText(AdminArray[num].GetId());
        Admin_nameField.setText(AdminArray[num].GetName());
        Admin_PasswordField.setText(AdminArray[num].GetPassword());
        Admin_ContactField.setText(AdminArray[num].GetContact());
    }
        

}


