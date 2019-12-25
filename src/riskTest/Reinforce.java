package riskTest;

/**
 * @author Owner
 *
 */
public class Reinforce {
	// Calculates the number of reinforcements a player should receive based on the
	// number of territories they own.
	public int newUnits(int numOfTers, int cardUnits) {
		int total = 0;
		if (numOfTers < 3) {
			total += 1;
		} else {
			total += (numOfTers / 3);
		}
		total += cardUnits;
		return total;
	}

}
