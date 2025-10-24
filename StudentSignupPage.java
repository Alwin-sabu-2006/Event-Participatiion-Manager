import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSignupPage {

    public static void createAndShowGUI() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}

        final JFrame signupFrame = new JFrame("Create Student Account");
        signupFrame.setSize(500, 600);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(10, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel userLabel = new JLabel("Username:");
        final JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        final JPasswordField passField = new JPasswordField();
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        final JPasswordField confirmPassField = new JPasswordField();
        JLabel regNoLabel = new JLabel("Registration Number:");
        final JTextField regNoField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        final JTextField emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        final JTextField phoneField = new JTextField();
        JLabel deptLabel = new JLabel("Department:");
        final JTextField deptField = new JTextField();
        JLabel genderLabel = new JLabel("Gender:");
        final JRadioButton maleButton = new JRadioButton("Male");
        final JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        JButton signupButton = new JButton("Sign Up");
        JButton backButton = new JButton("Back");

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                String confirmPass = new String(confirmPassField.getPassword());
                String regNo = regNoField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String dept = deptField.getText();
                String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : null);

                if (username.isEmpty() || password.isEmpty() || regNo.isEmpty() || email.isEmpty() || phone.isEmpty() || dept.isEmpty() || gender == null) {
                    JOptionPane.showMessageDialog(signupFrame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!password.equals(confirmPass)) {
                    JOptionPane.showMessageDialog(signupFrame, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                System.out.println("Student Signup attempt: User=" + username + ", RegNo=" + regNo);
                JOptionPane.showMessageDialog(signupFrame, "Student account created (simulation)!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Navigation removed
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Student Signup Back button clicked - (Navigation Removed)");
            }
        });

        mainPanel.add(userLabel);
        mainPanel.add(userField);
        mainPanel.add(passLabel);
        mainPanel.add(passField);
        mainPanel.add(confirmPassLabel);
        mainPanel.add(confirmPassField);
        mainPanel.add(regNoLabel);
        mainPanel.add(regNoField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneField);
        mainPanel.add(deptLabel);
        mainPanel.add(deptField);
        mainPanel.add(genderLabel);
        mainPanel.add(genderPanel);
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.add(signupButton);
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel);
        mainPanel.add(new JLabel(""));

        signupFrame.add(mainPanel);
        signupFrame.setLocationRelativeTo(null);
        signupFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}