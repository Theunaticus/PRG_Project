package GUI;

import javax.swing.JFrame;

import accessingdatamysql.DataObjects.*;


import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    Iterable<Administrator> AdminList = new MainController().getAllAdmins();

    final private Font mainFont = new Font("Admin ID", Font.PLAIN, 20);
    JTextField Admin_IDField = new JTextField("Admin ID");
    JLabel Admin_IDLabel = new JLabel("Admin ID", JLabel.CENTER);

    JTextField Admin_nameField = new JTextField("Admin name");
    JLabel Admin_nameLabel = new JLabel("Admin name", JLabel.CENTER);

    JTextField Admin_PasswordField = new JTextField("Admin Password");
    JLabel Admin_PasswordLabel = new JLabel("Admin Password", JLabel.CENTER);

    JTextField Admin_ContactField = new JTextField("Admin Contact");
    JLabel Admin_ContactLabel = new JLabel("Admin Contact", JLabel.CENTER);

    public AdminView() {

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
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(MainPanel);
        setVisible(true);

    }

    public static void DisplayFirstRecord() {
        MainController controller = new MainController();
        controller.getAllAdmins();

    }

}
