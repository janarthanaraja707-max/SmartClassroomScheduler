package smartclassroomscheduler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FacultyForm extends JFrame {

    JTextField txtId, txtName, txtSubject;
    JTable table;
    DefaultTableModel model;
    JButton btnAdd, btnUpdate, btnDelete, btnClear, btnBack;

    public FacultyForm() {
        setTitle("Faculty Management");
        setSize(620, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 248, 255));

        // ── Title ──
        JLabel lblTitle = new JLabel("👨‍🏫 Faculty Management");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(0, 70, 140));
        lblTitle.setBounds(150, 15, 320, 35);
        add(lblTitle);

        // ── Faculty ID ──
        JLabel lblId = new JLabel("Faculty ID:");
        lblId.setFont(new Font("Arial", Font.BOLD, 13));
        lblId.setBounds(50, 75, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(160, 75, 200, 28);
        txtId.setEditable(false);
        txtId.setBackground(new Color(220, 220, 220));
        add(txtId);

        // ── Faculty Name ──
        JLabel lblName = new JLabel("Faculty Name:");
        lblName.setFont(new Font("Arial", Font.BOLD, 13));
        lblName.setBounds(50, 120, 110, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(160, 120, 200, 28);
        add(txtName);

        // ── Subject ──
        JLabel lblSubject = new JLabel("Subject:");
        lblSubject.setFont(new Font("Arial", Font.BOLD, 13));
        lblSubject.setBounds(50, 165, 100, 25);
        add(lblSubject);

        txtSubject = new JTextField();
        txtSubject.setBounds(160, 165, 200, 28);
        add(txtSubject);

        // ── Buttons ──
        btnAdd = new JButton("➕ Add");
        btnAdd.setBounds(30, 215, 100, 32);
        btnAdd.setBackground(new Color(0, 153, 76));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 12));
        add(btnAdd);

        btnUpdate = new JButton("✏ Update");
        btnUpdate.setBounds(140, 215, 105, 32);
        btnUpdate.setBackground(new Color(0, 102, 204));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 12));
        add(btnUpdate);

        btnDelete = new JButton("🗑 Delete");
        btnDelete.setBounds(255, 215, 105, 32);
        btnDelete.setBackground(new Color(204, 0, 0));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
        add(btnDelete);

        btnClear = new JButton("🔄 Clear");
        btnClear.setBounds(370, 215, 100, 32);
        btnClear.setBackground(new Color(255, 153, 0));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Arial", Font.BOLD, 12));
        add(btnClear);

        btnBack = new JButton("🔙 Back");
        btnBack.setBounds(480, 215, 100, 32);
        btnBack.setBackground(new Color(100, 100, 100));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Arial", Font.BOLD, 12));
        add(btnBack);

        // ── Table ──
        model = new DefaultTableModel(
            new String[]{"ID", "Faculty Name", "Subject"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.getTableHeader().setBackground(new Color(0, 102, 204));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(30, 270, 555, 200);
        add(scroll);

        // ── Button Actions ──
        btnAdd.addActionListener(e -> addFaculty());
        btnUpdate.addActionListener(e -> updateFaculty());
        btnDelete.addActionListener(e -> deleteFaculty());
        btnClear.addActionListener(e -> clearFields());
        btnBack.addActionListener(e -> {
            dispose();
            new DashboardForm().setVisible(true);
        });

        // ── Row Click → Fill Fields ──
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    txtId.setText(model.getValueAt(row, 0).toString());
                    txtName.setText(model.getValueAt(row, 1).toString());
                    txtSubject.setText(model.getValueAt(row, 2).toString());
                }
            }
        });

        loadData();
        setVisible(true);
    }

    // ── Load Data ──
    void loadData() {
        model.setRowCount(0);
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM faculty")) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("subject")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Load Error: " + e.getMessage());
        }
    }

    // ── Add ──
    void addFaculty() {
        String name = txtName.getText().trim();
        String subject = txtSubject.getText().trim();

        if (name.isEmpty() || subject.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Please fill Faculty Name and Subject!");
            return;
        }
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                 "INSERT INTO faculty(name,subject) VALUES(?,?)")) {
            ps.setString(1, name);
            ps.setString(2, subject);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "✅ Faculty Added!");
            clearFields();
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Error: " + e.getMessage());
        }
    }

    // ── Update ──
    void updateFaculty() {
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Click a row from the table first!");
            return;
        }
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                 "UPDATE faculty SET name=?,subject=? WHERE id=?")) {
            ps.setString(1, txtName.getText().trim());
            ps.setString(2, txtSubject.getText().trim());
            ps.setInt(3, Integer.parseInt(txtId.getText().trim()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "✅ Faculty Updated!");
            clearFields();
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Error: " + e.getMessage());
        }
    }

    // ── Delete ──
    void deleteFaculty() {
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Click a row from the table first!");
            return;
        }
        int c = JOptionPane.showConfirmDialog(this,
            "Delete this faculty member?", "Confirm",
            JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) {
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                     "DELETE FROM faculty WHERE id=?")) {
                ps.setInt(1, Integer.parseInt(txtId.getText().trim()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "🗑️ Deleted!");
                clearFields();
                loadData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
            }
        }
    }

    // ── Clear ──
    void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtSubject.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        new FacultyForm();
    }
}