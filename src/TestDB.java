import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:smartclassroom.db");
            System.out.println("Database Created Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}