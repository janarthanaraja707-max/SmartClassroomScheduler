
package smartclassroomscheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReportForm extends JFrame {

    public ReportForm() {
        setTitle("Reports");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Reports", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setBounds(20, 15, 400, 30);
        add(lblTitle);

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setText(
            "Smart Classroom & Timetable Scheduler\n" +
            "----------------------------------------\n\n" +
            "Summary Report:\n\n" +
            " - Total Faculty Records: (see Faculty Management)\n" +
            " - Total Subjects: (see Subject Management)\n" +
            " - Total Classrooms: (see Classroom Management)\n" +
            " - Total Timetable Entries: (see Timetable Management)\n\n" +
            "This screen can be extended to generate\n" +
            "detailed reports as required."
        );
        JScrollPane scrollPane = new JScrollPane(reportArea);
        scrollPane.setBounds(40, 60, 360, 230);
        add(scrollPane);

        JButton btnBack = new JButton("Back to Dashboard");
        btnBack.setBounds(135, 310, 160, 30);
        add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ReportForm.this.dispose();
                new DashboardForm().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportForm().setVisible(true);
            }
        });
    }
}