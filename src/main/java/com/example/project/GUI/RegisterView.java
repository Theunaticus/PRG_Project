package com.example.project.GUI;

import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

import com.example.project.MainController;
import com.example.project.Register;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    private static final JTextComponent Register_PasswordField = null;
    static Register[] RegisterArray = new Register[40];
    static int Position = 0;


    final private Font mainFont = new Font("Arial", Font.PLAIN, 20);
    static JTextField Register_IDField = new JTextField("Register ID");
    JLabel Register_IDLabel = new JLabel("Register ID", JLabel.CENTER);

    static JTextField Register_nameField = new JTextField("Register name");
    JLabel Register_nameLabel = new JLabel("Register name", JLabel.CENTER);

    static JTextField Register_addressField = new JTextField("Register address");
    JLabel Register_addressLabel = new JLabel("Register address", JLabel.CENTER);

    static JTextField Register_emailField = new JTextField("Register email");
    JLabel Register_emailLabel = new JLabel("Register email", JLabel.CENTER);

    static JTextField Register_passwordField = new JTextField("Register password");
    JLabel Register_passwordLabel = new JLabel("Register password", JLabel.CENTER);

    static JTextField Course_NameField = new JTextField("Course Name");
    JLabel Course_NameLabel = new JLabel("Course Name", JLabel.CENTER);

    public RegisterView() {
        DisplayFirstRecord();
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
            addNewRegister();
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
        setTitle("Register");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(MainPanel);
        setVisible(true);

    }




    public void DeleteMember(){
        Register[] registerArrayReplacement = new Register[RegisterArray.length-1];
        RegisterArray[Position] = null;
        
        for (int i = 0; i < RegisterArray.length; i++) {
            if  (RegisterArray[i] != null) {
                registerArrayReplacement[i] = RegisterArray[i];
            }
            registerArrayReplacement[i] = RegisterArray[i];
        }
        RegisterArray = registerArrayReplacement;


    }

    public void ReplaceInfo(){
        RegisterArray[Position].SetId( Integer.parseInt(Register_IDField.getText()) );
        RegisterArray[Position].SetName(Register_nameField.getText());
        RegisterArray[Position].SetPassword(Register_PasswordField.getText());
        RegisterArray[Position].SetAddress(Register_addressField.getText());
        RegisterArray[Position].SetEmail(Register_emailField.getText());
        RegisterArray[Position].SetCourse(Course_NameField.getText());
    }

    public void addNewRegister(){
        try {
            MainController controller = new MainController();
            controller.addNewRegister( Register_nameField.getText(), Register_addressField.getText(), Register_emailField.getText(),
                    Register_PasswordField.getText(), Course_NameField.getText() );
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            AddFakeMember();
        } 
        
    }

    void AddFakeMember(){
        Register[] registerArrayReplacement = new Register[RegisterArray.length+1];
        Register register = new Register();
        register.SetId( Integer.parseInt(Register_IDField.getText()) );
        register.SetName(Register_nameField.getText());
        register.SetPassword(Register_PasswordField.getText());
        register.SetAddress(Register_addressField.getText());
        register.SetEmail(Register_emailField.getText());
        register.SetCourse(Course_NameField.getText());
       
        for (int i = 0; i < RegisterArray.length; i++) {
            registerArrayReplacement[i] = RegisterArray[i];
        }
        registerArrayReplacement[RegisterArray.length] = register;
        RegisterArray = registerArrayReplacement;
    }

    public void MoveToRecord(int num){
        if (RegisterArray.length > 0) {
            Position += num;
            if (Position < 0) {
                Position = RegisterArray.length - 1;
                while(RegisterArray[Position] == null){
                    Position--;
                }
            }else if(Position>=RegisterArray.length-1){
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
            Iterable<Register> RegisterList = mainController.getAllRegisters();
            
            int count = 0;
            if(RegisterArray.length<=0){
                System.out.println("No records");
                GenerateFakeValues();
            }else{
                for (Register register : RegisterList) {
                    RegisterArray[count] = register;
                    count++;
                }
                QuickTextSet(0);

            }
        } catch (NullPointerException e) {
            GenerateFakeValues();
        }
        
        
            
    }

    void GenerateFakeValues(){
        RegisterArray = new Register[5];
        Register register = new Register();
        register.SetId(1);
        register.SetName("Dave");
        register.SetPassword("Password");
        register.SetAddress("65 Main Street");
        register.SetEmail("Dave@gmail.com");
        register.SetCourse("Prg");
        RegisterArray[0] = register;
        Register register1 = new Register();
        register1.SetId(2);
        register1.SetName("Steve");
        register1.SetPassword("CheesNugget");
        register1.SetAddress("89 north street");
        register1.SetEmail("Steve@gmail.com");
        register1.SetCourse("Prg");
        RegisterArray[1] = register1;
        Register register2 = new Register();
        register2.SetId(3);
        register2.SetName("Bob");
        register2.SetPassword("RickRoll68");
        register2.SetAddress("92 south street");
        register2.SetEmail("Bob@gmail.com");
        register2.SetCourse("Prg");
        RegisterArray[2] = register2;
        Register register3 = new Register();
        register3.SetId(4);
        register3.SetName("Rick");
        register3.SetPassword("1234566");
        register3.SetAddress("92 west street");
        register3.SetEmail("Rick@gmail.com");
        register3.SetCourse("Prg");
        RegisterArray[3] = register3;
        Register register4 = new Register();
        register4.SetId(5);
        register4.SetName("Olivar");
        register4.SetPassword("hawian9827");
        register4.SetAddress("1 east street");
        register4.SetEmail("Olivar@gmail.com");
        register4.SetCourse("Prg");
        RegisterArray[4] = register4;

        QuickTextSet(0);
    }

    public static void QuickTextSet(int num){
        Register_IDField.setText(String.valueOf(RegisterArray[num].GetId()) );
        if(RegisterArray[num].GetName()!=null){
            Register_nameField.setText(RegisterArray[num].GetName());
        }else {
            Register_nameField.setText("");
        }
        if(RegisterArray[num].GetPassword()!=null){
            Register_PasswordField.setText(RegisterArray[num].GetPassword());
        }else {
            Register_PasswordField.setText("");
        }
        if(RegisterArray[num].GetAddress()!=null){
            Register_addressField.setText(RegisterArray[num].GetAddress());
        }else {
            Register_addressField.setText("");
        }
        if(RegisterArray[num].GetEmail()!=null){
            Register_emailField.setText(RegisterArray[num].GetEmail());
        }else {
            Register_emailField.setText("");
        }
        if(RegisterArray[num].GetCourse()!=null){
            Course_NameField.setText(RegisterArray[num].GetCourse());
        }else {
            Course_NameField.setText("");
        }

        

        
    }
       

}
