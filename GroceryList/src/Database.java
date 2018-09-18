import java.sql.*;

//Contient les méthodes de manipultation des données de la table "List"
//de la base de données.

public class Database {
	
	public void addItem(String itemName, int avail, int position) {
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:list.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = "INSERT INTO ITEMS (ITEMNAME,AVAILABILITY,POSITION) " +
						"VALUES (itemName, avail, position);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		}
		catch (Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
	
	

}
