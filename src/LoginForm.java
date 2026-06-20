import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnReset;

    public LoginForm() {
        setTitle("Smart Classroom & Timetable Scheduler - Login");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Smart Classroom & Timetable Scheduler", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setBounds(20, 20, 380, 30);
        add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(60, 90, 100, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(170, 90, 180, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(60, 130, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(170, 130, 180, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 190, 100, 30);
        add(btnLogin);

        btnReset = new JButton("Reset");
        btnReset.setBounds(240, 190, 100, 30);
        add(btnReset);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Login Successful!");
                    LoginForm.this.dispose();
                    new smartclassroomscheduler.DashboardForm().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtUsername.setText("");
                txtPassword.setText("");
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}