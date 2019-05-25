
public class Item {

	private String itemName;
	private int itemAvailability;
	private int itemPosition;
	
	
	public Item(String name, int avail, int pos) {
		
		itemName = name;
		itemAvailability = avail;
		itemPosition = pos;

	}


	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	/**
	 * @return the itemAvailability
	 */
	public int getItemAvailability() {
		return itemAvailability;
	}


	/**
	 * @param itemAvailability the itemAvailability to set
	 */
	public void setItemAvailability(int itemAvailability) {
		this.itemAvailability = itemAvailability;
	}


	/**
	 * @return the itemPosition
	 */
	public int getItemPosition() {
		return itemPosition;
	}


	/**
	 * @param itemPosition the itemPosition to set
	 */
	public void setItemPosition(int itemPosition) {
		this.itemPosition = itemPosition;
	}

}
