package smartclassroomscheduler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SubjectForm extends JFrame {

    private JTextField txtCode, txtName, txtCredits;
    private JTable table;
    private DefaultTableModel model;

    public SubjectForm() {
        setTitle("Subject Management");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Subject Management", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setBounds(20, 15, 440, 30);
        add(lblTitle);

        JLabel lblCode = new JLabel("Subject Code:");
        lblCode.setBounds(40, 60, 100, 25);
        add(lblCode);

        txtCode = new JTextField();
        txtCode.setBounds(180, 60, 200, 25);
        add(txtCode);

        JLabel lblName = new JLabel("Subject Name:");
        lblName.setBounds(40, 100, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(180, 100, 200, 25);
        add(txtName);

        JLabel lblCredits = new JLabel("Credits:");
        lblCredits.setBounds(40, 140, 100, 25);
        add(lblCredits);

        txtCredits = new JTextField();
        txtCredits.setBounds(180, 140, 200, 25);
        add(txtCredits);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(140, 180, 100, 30);
        add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(260, 180, 100, 30);
        add(btnClear);

        model = new DefaultTableModel(new Object[]{"Subject Code", "Subject Name", "Credits"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 230, 400, 130);
        add(scrollPane);

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBounds(150, 375, 160, 30);
        add(btnBack);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String code = txtCode.getText();
                String name = txtName.getText();
                String credits = txtCredits.getText();

                if (code.isEmpty() || name.isEmpty() || credits.isEmpty()) {
                    JOptionPane.showMessageDialog(SubjectForm.this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.addRow(new Object[]{code, name, credits});
                    txtCode.setText("");
                    txtName.setText("");
                    txtCredits.setText("");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtCode.setText("");
                txtName.setText("");
                txtCredits.setText("");
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SubjectForm.this.dispose();
                new DashboardForm().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectForm().setVisible(true);
            }
        });
    }
}