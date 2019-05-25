//Programme main
public class List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Database baseDonnee = new Database("list.db");
		Item item = new Item("Lait", 1, 1);
		baseDonnee.addItem(item);
		baseDonnee.listRec();
		baseDonnee.close();
		
	}
	 
	/** Pour un affichage en temps réel des données de la table "items" dans un objet Java table, s'inspirer
	 *  de la page 507 du livre "Aprenez à développer en Java".
	 *  connectDB();
	 *  addItem("'Pain hot dog'", "0", "1");
	 *  listRec();  
	*/
}