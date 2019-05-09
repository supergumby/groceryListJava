import java.sql.*;

/*Contient les méthodes de manipultation des données de la table "List"
de la base de données.*/

public class Database {
	
	/**
	 *	Constructeur d'objet base de données 
	 */
	public Database() {
		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:list.db");

		} catch (Exception e) {
			System.err.println(e.getClass().getName()+ ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");

		// Création de la table d'item "items" dans le fichier de base de données "list.db" s'il n'existe pas.
		try {
			stmt = c.createStatement();
			String sql = "CREATE TABLE ITEMS " +
					"(ID 				INTEGER PRIMARY KEY AUTOINCREMENT, " +
					" ITEMNAME 			TEXT NOT NULL, " +
					" AVAILABILITY 		INT, " +
					" POSITION 			INT)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() +": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
	
	
	/*
	* Méthode qui ajoute un enregistrement à la base de données.
	*/
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
