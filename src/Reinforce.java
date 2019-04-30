

/**
 * @author Owner
 *
 */
public class Reinforce {

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
