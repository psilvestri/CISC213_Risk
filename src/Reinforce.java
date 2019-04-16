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

	//Method for determining the number of units gained from cards.
	public void tradeCards(int cardOne, int cardTwo, int cardThree) {
		if ((cardOne - cardTwo == 0) && (cardOne - cardThree == 0)) {	//If all three cards are the same the player gets 10 more units.
			cardUnits = 10;
		}
		else if (cardOne + cardTwo + cardThree == 6) {	//If there is one of each cards then the player gets 15 extra units.
			cardUnits = 15;
		}
		else  {
			System.out.println("Cannot trade in cards.");	//If neither of those conditions are met then the player gets 0 bonus units.
			cardUnits = 0;
		}
	}
	
	
	//Sets the int variables above for the number of territories and the units from cards.
	public void setVals(int totalTers) {
		numOfTers = totalTers;
	}

	//calculates the new units given based of the number of territories and the units gained from cards
	public int newUnits() {
		int total = 0;
		if (numOfTers < 3) {
			total += 1;
		} else {
			total += (numOfTers / 3);
		}
		total += cardUnits;
		System.out.println(total);
		return total;
	}

	//Getters and setters
	public int getTotalReinf() {
		return totalReinf;
	}

	public void setTotalReinf(int totalReinf) {
		this.totalReinf = totalReinf;
	}

}
