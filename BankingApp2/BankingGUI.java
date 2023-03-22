import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankingGUI extends JFrame {
    private JTextField unField;
    private JPasswordField psField;
    
    public BankingGUI() {
        setTitle("Banking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        // Create username label and field
        JLabel unLabel = new JLabel("Username:");
        unField = new JTextField(20);
        JPanel unPanel = new JPanel(new FlowLayout());
        unPanel.add(unLabel);
        unPanel.add(unField);
        
        // Create password label and field
        JLabel psLabel = new JLabel("Password:");
        psField = new JPasswordField(20);
        JPanel psPanel = new JPanel(new FlowLayout());
        psPanel.add(psLabel);
        psPanel.add(psField);
        
        // Create login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = unField.getText();
                char[] passwordChars = psField.getPassword();
                String password = new String(passwordChars);
                
                // Check login credentials
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(BankingGUI.this, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(BankingGUI.this, "Login failed. Please try again.");
                }
                
                // Clear password field
                psField.setText("");
            }
        });
        
        // Create panel for login button
        JPanel loginPanel = new JPanel(new FlowLayout());
        loginPanel.add(loginButton);
        
        // Add panels to frame
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(unPanel);
        mainPanel.add(psPanel);
        mainPanel.add(loginPanel);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BankingGUI();
    }
}
