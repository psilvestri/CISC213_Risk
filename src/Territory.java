/**
 * 
 */

/**
 * @author bastianb72361
 *
 */
public class Territory {

	private int units;
	private int ID;
	
	public void changeUnits(int x) {
		units += x;
	}
	
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
}
