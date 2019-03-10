import java.sql.*;


//Programme main qui fait tout
public class List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//connectDB();
		//addItem("'Pain hot dog'", "0", "1");
		//listRec();
	}

	
	// Création du fichier de base de données "list.db" s'il n'existe pas.
	/**
	 public static void connectDB() {
	
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
 */
	// Méthodes utiles pour manipuler les données de la base de données.
	
	// Méthode qui ajoute un enregistrement à la base de données.
	public static void addItem(String itemName, String avail, String position) {
		
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:list.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			
			stmt = c.createStatement();
			String sql = "INSERT INTO ITEMS (ITEMNAME,AVAILABILITY,POSITION) " +
						"VALUES (" + itemName + ", " + avail + ", " + position +");";
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
	
	// Méthode qui affiche les enregistrements de la table "items" de la base de données "list.db".
	public static void listRec() {
		
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:list.db");
			c.setAutoCommit(false);
			System.out.println("Opened databse successfully");
			
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ITEMS;");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String itemName = rs.getString("itemName");
				int availability = rs.getInt("availability");
				int position = rs.getInt("position");
				
				System.out.println("ID = " + id);
				System.out.println("ITEMNAME = " + itemName);
				System.out.println("AVAILABILITY = " + availability);
				System.out.println("POSITION = " + position);
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			c.close();		
		}
		catch (Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
	
	/** Pour un affichage en temps réel des données de la table "items" dans un objet Java table, s'inspirer
	 *  de la page 507 du livre "Aprenez à développer en Java".
	*/
}