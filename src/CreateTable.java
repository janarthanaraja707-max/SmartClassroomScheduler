import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

        Connection conn = DBConnection.connect();

        try {

            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS faculty ("
                    + "id TEXT,"
                    + "name TEXT,"
                    + "subject TEXT"
                    + ");";

            stmt.execute(sql);

            System.out.println("Faculty Table Created");

        } catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, ex.getMessage());

       }
    }
}