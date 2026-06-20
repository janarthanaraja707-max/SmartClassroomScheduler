package smartclassroomscheduler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TimetableForm extends JFrame {

    private JTextField txtDay, txtTime, txtSubject, txtFaculty, txtRoom;
    private JTable table;
    private DefaultTableModel model;

    public TimetableForm() {
        setTitle("Timetable Management");
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Timetable Management", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setBounds(20, 15, 540, 30);
        add(lblTitle);

        JLabel lblDay = new JLabel("Day:");
        lblDay.setBounds(40, 60, 100, 25);
        add(lblDay);

        txtDay = new JTextField();
        txtDay.setBounds(150, 60, 150, 25);
        add(txtDay);

        JLabel lblTime = new JLabel("Time Slot:");
        lblTime.setBounds(320, 60, 100, 25);
        add(lblTime);

        txtTime = new JTextField();
        txtTime.setBounds(420, 60, 130, 25);
        add(txtTime);

        JLabel lblSubject = new JLabel("Subject:");
        lblSubject.setBounds(40, 100, 100, 25);
        add(lblSubject);

        txtSubject = new JTextField();
        txtSubject.setBounds(150, 100, 150, 25);
        add(txtSubject);

        JLabel lblFaculty = new JLabel("Faculty:");
        lblFaculty.setBounds(320, 100, 100, 25);
        add(lblFaculty);

        txtFaculty = new JTextField();
        txtFaculty.setBounds(420, 100, 130, 25);
        add(txtFaculty);

        JLabel lblRoom = new JLabel("Classroom:");
        lblRoom.setBounds(40, 140, 100, 25);
        add(lblRoom);

        txtRoom = new JTextField();
        txtRoom.setBounds(150, 140, 150, 25);
        add(txtRoom);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(180, 185, 100, 30);
        add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(300, 185, 100, 30);
        add(btnClear);

        model = new DefaultTableModel(new Object[]{"Day", "Time Slot", "Subject", "Faculty", "Classroom"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 235, 510, 150);
        add(scrollPane);

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBounds(200, 400, 160, 30);
        add(btnBack);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String day = txtDay.getText();
                String time = txtTime.getText();
                String subject = txtSubject.getText();
                String faculty = txtFaculty.getText();
                String room = txtRoom.getText();

                if (day.isEmpty() || time.isEmpty() || subject.isEmpty() || faculty.isEmpty() || room.isEmpty()) {
                    JOptionPane.showMessageDialog(TimetableForm.this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.addRow(new Object[]{day, time, subject, faculty, room});
                    txtDay.setText("");
                    txtTime.setText("");
                    txtSubject.setText("");
                    txtFaculty.setText("");
                    txtRoom.setText("");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtDay.setText("");
                txtTime.setText("");
                txtSubject.setText("");
                txtFaculty.setText("");
                txtRoom.setText("");
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TimetableForm.this.dispose();
                new DashboardForm().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimetableForm().setVisible(true);
            }
        });
    }
}