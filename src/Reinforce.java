/**
 * 
 */

/**
 * @author Brennen Bastian
 *
 */
public class Reinforce {

	private int numOfTers, cardUnits, totalReinf;

	/*
	 * public Reinforce(int terrNums, int cardVal) { numOfTers = terrNums; cardUnits
	 * = cardVal; }
	 */

	//Sets the int variables above for the number of territories and the units from cards.
	public void setVals(int totalTers, int cardArmy) {
		numOfTers = totalTers;
		cardUnits = cardArmy;
	}

	//calculates the new units given based of the number of territories and the units gained from cards
	public void newUnits() {
		int total = 0;
		if (numOfTers < 3) {
			total += 1;
		} else {
			total += (numOfTers / 3);
		}
		total += cardUnits;
		setTotalReinf(total);
	}

	//Getters and setters
	public int getTotalReinf() {
		return totalReinf;
	}

	public void setTotalReinf(int totalReinf) {
		this.totalReinf = totalReinf;
	}

}
