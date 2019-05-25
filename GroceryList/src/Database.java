import java.sql.*;


/*Contient les méthodes de manipultation des données de la table "List"
de la base de données.*/

public class Database {
	
	private String DBPath = "Chemin aux base de donnée SQLite";
	private Connection connection = null;
	private Statement statement = null;	
	
	/**
	 *	Constructeur d'objet base de données
	 */
	public Database(String dBPath) {
		DBPath = dBPath;
	}	
	
	
	/**
	 *	Création de la connexion vers la base de données identifiée dans le constructeur.
	 */
	public void connect() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
			statement = connection.createStatement();
			System.out.println("Connexion à " + DBPath + " avec succès");
			
		}	catch (ClassNotFoundException notFoundException) {
				notFoundException.printStackTrace();
				System.out.println("Erreur de connexion");
				
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
				System.out.println("Erreur de connexion");
			}
	}
	
	/**
	 * 	Fermeture de la base de données.
	 */
	public void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Obtention du résultat d'une requête interrogeant la base de données.
	 * @param requete
	 * @return Le résultat d'une requête SQL sous la forme d'un ResultSet
	 */
	public ResultSet query(String requete) {
		ResultSet resultat = null;
		try {
			resultat = statement.executeQuery(requete);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur dans la requet : " + requete);
		}
		return resultat;

	}
	
	/**
	 * Ajout d'un objet item à la liste d'items de la base de données.
	 * @param item
	 */
	public void addItem(Item item) {
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO ITEMS (ITEMNAME, AVAILABILITY, POSITION)"
					+ " VALUES('" + item.getItemName() + "' ," +
					item.getItemAvailability() + " ," + item.getItemPosition() + ")");
			System.out.println("Insertion avec Succès");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Méthode qui affiche les enregistrements de la table "items" de la base de données "list.db".
	 */
		public void listRec() {
			
			try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM ITEMS;");
				
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
					
			}
			catch (Exception e){
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			
			System.out.println("Operation done successfully");
		}
		
	// PAS REQUIS SI ON PREND POUR ACQUIS QUE LA TABLE EXISTE DÉJÀ AU DÉPART	
		/*// Création de la table d'item "items" dans le fichier de base de données "list.db" s'il n'existe pas.
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
		}*/
		
		
}
