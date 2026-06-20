package smartclassroomscheduler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:smartclassroom.db");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void initializeDB() {
        System.out.println("Database Initialized");
    }
}