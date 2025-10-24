import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLoginPage {

    public static void createAndShowGUI() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}

        final JFrame studentFrame = new JFrame("Student Login");
        studentFrame.setSize(400, 200);
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel userLabel = new JLabel("Username:");
        final JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        final JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                System.out.println("Student Login attempt with user: " + username);
                // Placeholder - show success/fail message, no DB check
                if ("student".equals(username) && "pass".equals(password)) {
                     JOptionPane.showMessageDialog(studentFrame, "Login Successful (Simulation)!", "Success", JOptionPane.INFORMATION_MESSAGE);
                     System.out.println("Student login successful! (Simulated)");
                 } else {
                     JOptionPane.showMessageDialog(studentFrame,
                             "Invalid username or password.",
                             "Login Failed",
                             JOptionPane.ERROR_MESSAGE);
                 }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Student Login Back button clicked - (Navigation Removed)");
            }
        });

        mainPanel.add(userLabel);
        mainPanel.add(userField);
        mainPanel.add(passLabel);
        mainPanel.add(passField);
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.add(backButton);
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginPanel.add(loginButton);
        mainPanel.add(backPanel);
        mainPanel.add(loginPanel);

        studentFrame.add(mainPanel);
        studentFrame.setLocationRelativeTo(null);
        studentFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}