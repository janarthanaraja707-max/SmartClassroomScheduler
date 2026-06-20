package smartclassroomscheduler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ClassroomForm extends JFrame {

    private JTextField txtRoomNo, txtCapacity, txtType;
    private JTable table;
    private DefaultTableModel model;

    public ClassroomForm() {
        setTitle("Classroom Management");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Classroom Management", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setBounds(20, 15, 440, 30);
        add(lblTitle);

        JLabel lblRoomNo = new JLabel("Room No:");
        lblRoomNo.setBounds(40, 60, 100, 25);
        add(lblRoomNo);

        txtRoomNo = new JTextField();
        txtRoomNo.setBounds(180, 60, 200, 25);
        add(txtRoomNo);

        JLabel lblCapacity = new JLabel("Capacity:");
        lblCapacity.setBounds(40, 100, 100, 25);
        add(lblCapacity);

        txtCapacity = new JTextField();
        txtCapacity.setBounds(180, 100, 200, 25);
        add(txtCapacity);

        JLabel lblType = new JLabel("Room Type:");
        lblType.setBounds(40, 140, 100, 25);
        add(lblType);

        txtType = new JTextField();
        txtType.setBounds(180, 140, 200, 25);
        add(txtType);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(140, 180, 100, 30);
        add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(260, 180, 100, 30);
        add(btnClear);

        model = new DefaultTableModel(new Object[]{"Room No", "Capacity", "Room Type"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 230, 400, 130);
        add(scrollPane);

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBounds(150, 375, 160, 30);
        add(btnBack);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String roomNo = txtRoomNo.getText();
                String capacity = txtCapacity.getText();
                String type = txtType.getText();

                if (roomNo.isEmpty() || capacity.isEmpty() || type.isEmpty()) {
                    JOptionPane.showMessageDialog(ClassroomForm.this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.addRow(new Object[]{roomNo, capacity, type});
                    txtRoomNo.setText("");
                    txtCapacity.setText("");
                    txtType.setText("");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtRoomNo.setText("");
                txtCapacity.setText("");
                txtType.setText("");
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ClassroomForm.this.dispose();
                new DashboardForm().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassroomForm().setVisible(true);
            }
        });
    }
}