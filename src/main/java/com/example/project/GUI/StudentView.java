package com.example.project.GUI;

import javax.swing.JFrame;

import com.example.project.MainController;
import com.example.project.Student;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {
    static Student[] StudentArray = new Student[40];
    static int Position = 0;


    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);

    static JTextField student_IDField = new JTextField("Student ID");
    JLabel student_IDLabel = new JLabel("Student ID", JLabel.CENTER);

    static JTextField student_nameField = new JTextField("Student name");
    JLabel student_nameLabel = new JLabel("Student name", JLabel.CENTER);

    static JTextField student_addressField = new JTextField("Student address");
    JLabel student_addressLabel = new JLabel("Student address", JLabel.CENTER);

    static JTextField student_emailField = new JTextField("Student email");
    JLabel student_emailLabel = new JLabel("Student email", JLabel.CENTER);

    static JTextField student_passwordField = new JTextField("Student password");
    JLabel student_passwordLabel = new JLabel("Student password", JLabel.CENTER);

    public StudentView() {
        DisplayFirstRecord();
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
            ReplaceInfo();
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
            DeleteMember();
        });
        JButton AddButton = new JButton("Add record");
        AddButton.setFont(mainFont);
        AddButton.addActionListener(arg0 -> {
            AddNewStudent();
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
        setTitle("Student");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(MainPanel);
        setVisible(true);

    }




    public void DeleteMember(){
        Student[] StudentArrayReplacement = new Student[StudentArray.length-1];
        StudentArray[Position] = null;
        
        for (int i = 0; i < StudentArray.length; i++) {
            if  (StudentArray[i] != null) {
                StudentArrayReplacement[i] = StudentArray[i];
            }
            StudentArrayReplacement[i] = StudentArray[i];
        }
        StudentArray = StudentArrayReplacement;


    }

    public void ReplaceInfo(){
        StudentArray[Position].SetId( Integer.parseInt(student_IDField.getText()) );
        StudentArray[Position].SetName(student_nameField.getText());
        StudentArray[Position].SetPassword(student_passwordField.getText());
        StudentArray[Position].SetEmail(student_emailField.getText());
        StudentArray[Position].SetAddress(student_addressField.getText());
    }

    public void AddNewStudent(){
        try {
            MainController controller = new MainController();
            controller.addNewStudent( student_nameField.getText(), student_addressField.getText(), student_emailField.getText(),student_passwordField.getText());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            AddFakeMember();
        } 
        
    }

    void AddFakeMember(){
        Student[] StudentArrayReplacement = new Student[StudentArray.length+1];
        Student stud = new Student();
        stud.SetId( Integer.parseInt(student_IDField.getText()) );
        stud.SetName(student_nameField.getText());
        stud.SetPassword(student_passwordField.getText());
        stud.SetEmail(student_emailField.getText());
        stud.SetAddress(student_addressField.getText());
        for (int i = 0; i < StudentArray.length; i++) {
            StudentArrayReplacement[i] = StudentArray[i];
        }
        StudentArrayReplacement[StudentArray.length] = stud;
        StudentArray = StudentArrayReplacement;
    }

    public void MoveToRecord(int num){
        if (StudentArray.length > 0) {
            Position += num;
            if (Position < 0) {
                Position = StudentArray.length - 1;
                while(StudentArray[Position] == null){
                    Position--;
                }
            }else if(Position>=StudentArray.length-1){
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
            Iterable<Student> StudentList = mainController.getAllStudents();
            
            int count = 0;
            if(StudentArray.length<=0){
                System.out.println("No records");
                GenerateFakeValues();
            }else{
                for (Student stud : StudentList) {
                    StudentArray[count] = stud;
                }
                QuickTextSet(0);

            }
        } catch (NullPointerException e) {
            GenerateFakeValues();
        }
        
        
            
    }

    void GenerateFakeValues(){
        StudentArray = new Student[5];
        Student stud = new Student();
        stud.SetId(1);
        stud.SetName("Jonathan");
        stud.SetAddress("64 Main St");
        stud.SetEmail("Jonathan@gmail.com");
        stud.SetPassword("Secret");
        StudentArray[0] = stud;

        stud = new Student();
        stud.SetId(2);
        stud.SetName("Erica");
        stud.SetAddress("55 Main St");
        stud.SetEmail("Erica@gmail.com");
        stud.SetPassword("Cheesecake4life");
        StudentArray[1] = stud;

        stud = new Student();
        stud.SetId(3);
        stud.SetName("Hernando");
        stud.SetAddress("66 Main St");
        stud.SetEmail("Hernando@gmail.com");
        stud.SetPassword("Kingston");
        StudentArray[2] = stud;

        stud = new Student();
        stud.SetId(4);
        stud.SetName("Steve");
        stud.SetAddress("77 Main St");
        stud.SetEmail("Steve@gmail.com");
        stud.SetPassword("Capn_America");
        StudentArray[3] = stud;

        stud = new Student();
        stud.SetId(5);
        stud.SetName("Roderick");
        stud.SetAddress("88 Main St");
        stud.SetEmail("Roderick@gmail.com");
        stud.SetPassword("GoT");
        StudentArray[4] = stud;

        QuickTextSet(0);
    }

    public static void QuickTextSet(int num){
        student_IDField.setText(String.valueOf(StudentArray[num].GetId()));
        student_nameField.setText(StudentArray[num].GetName());
        student_passwordField.setText(StudentArray[num].GetPassword());
        student_addressField.setText(StudentArray[num].GetAddress());
        student_emailField.setText(StudentArray[num].GetEmail());
    }
}
