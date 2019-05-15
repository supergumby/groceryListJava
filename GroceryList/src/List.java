//Programme main
public class List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Database baseDonnee = new Database();
		baseDonnee.addItem("'Lait'", 0, 5);
		baseDonnee.listRec();
		
	}
	 
	/** Pour un affichage en temps réel des données de la table "items" dans un objet Java table, s'inspirer
	 *  de la page 507 du livre "Aprenez à développer en Java".
	 *  connectDB();
	 *  addItem("'Pain hot dog'", "0", "1");
	 *  listRec();  
	*/
}