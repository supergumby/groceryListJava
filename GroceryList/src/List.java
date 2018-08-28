import java.sql.Connection;
import java.sql.DriverManager;

//Programme main
public class List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		connectDB();
	}

	public static void connectDB() {
		Connection c = null;
		
			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:test.db");
			
			} catch (Exception e) {
				System.err.println(e.getClass().getName()+ ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Opened database successfully");
		}
}
