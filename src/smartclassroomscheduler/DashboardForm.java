package smartclassroomscheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardForm extends JFrame {

    public DashboardForm() {
        setTitle("Smart Classroom & Timetable Scheduler - Dashboard");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Smart Classroom & Timetable Scheduler", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setBounds(20, 20, 400, 30);
        add(lblTitle);

        JLabel lblDashboard = new JLabel("Dashboard", JLabel.CENTER);
        lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDashboard.setBounds(20, 50, 400, 25);
        add(lblDashboard);

        JButton btnFaculty = new JButton("Faculty Management");
        btnFaculty.setBounds(120, 100, 200, 35);
        add(btnFaculty);

        JButton btnSubject = new JButton("Subject Management");
        btnSubject.setBounds(120, 150, 200, 35);
        add(btnSubject);

        JButton btnClassroom = new JButton("Classroom Management");
        btnClassroom.setBounds(120, 200, 200, 35);
        add(btnClassroom);

        JButton btnTimetable = new JButton("Timetable Management");
        btnTimetable.setBounds(120, 250, 200, 35);
        add(btnTimetable);

        JButton btnReports = new JButton("Reports");
        btnReports.setBounds(120, 300, 200, 35);
        add(btnReports);

        btnFaculty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DashboardForm.this.dispose();
                new FacultyForm().setVisible(true);
            }
        });

        btnSubject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DashboardForm.this.dispose();
                new SubjectForm().setVisible(true);
            }
        });

        btnClassroom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DashboardForm.this.dispose();
                new ClassroomForm().setVisible(true);
            }
        });

        btnTimetable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DashboardForm.this.dispose();
                new TimetableForm().setVisible(true);
            }
        });

        btnReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DashboardForm.this.dispose();
                new ReportForm().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }
}