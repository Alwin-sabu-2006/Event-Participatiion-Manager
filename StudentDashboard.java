import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard {

    public static void createAndShowGUI() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}

        final JFrame dashboardFrame = new JFrame("Student Dashboard");
        dashboardFrame.setSize(600, 250);
        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.setLayout(new BorderLayout());

        JPanel topButtonsPanel = new JPanel();
        topButtonsPanel.setLayout(new GridLayout(1, 3, 15, 15));
        topButtonsPanel.setBorder(new EmptyBorder(30, 30, 15, 30));

        JButton viewAllEventsButton = new JButton("View All Events");
        JButton myEventsButton = new JButton("My Registered Events");
        JButton viewProfileButton = new JButton("View Profile");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        viewAllEventsButton.setFont(buttonFont);
        myEventsButton.setFont(buttonFont);
        viewProfileButton.setFont(buttonFont);

        topButtonsPanel.add(viewAllEventsButton);
        topButtonsPanel.add(myEventsButton);
        topButtonsPanel.add(viewProfileButton);

        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        logoutPanel.setBorder(new EmptyBorder(10, 30, 30, 30));

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(buttonFont);
        logoutPanel.add(logoutButton);

        viewAllEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View All Events button clicked - (Navigation Removed)");
            }
        });

        myEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("My Registered Events button clicked - (Navigation Removed)");
            }
        });

        viewProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View Profile button clicked - (Navigation Removed)");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Student Logout button clicked - (Navigation Removed)");
            }
        });

        dashboardFrame.add(topButtonsPanel, BorderLayout.CENTER);
        dashboardFrame.add(logoutPanel, BorderLayout.SOUTH);

        dashboardFrame.setLocationRelativeTo(null);
        dashboardFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}