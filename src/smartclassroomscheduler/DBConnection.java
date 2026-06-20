package smartclassroomscheduler;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection connect() {

        Connection conn = null;

        try {

            String url = "jdbc:sqlite:smartclassroom.db";

            conn = DriverManager.getConnection(url);

            System.out.println("Database Connected");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return conn;
    }
}
