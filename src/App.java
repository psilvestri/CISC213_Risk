import java.util.Random;

/**
 * 
 */

/**
 * @author bastianb72361
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Territory[] terr = new Territory[5];
		Reinforce ref = new Reinforce();
		Random rand = new Random();
		
		for (int i = 0; i < 5; i++) {
			terr[i] = new Territory();
			terr[i].setID(i + 1);
			terr[i].setUnits(rand.nextInt(9) + 1);
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(terr[i].getID() + "   " + terr[i].getUnits());

		}

		ref.tradeCards(1, 2, 3);
		ref.setVals(10);
		terr[3].changeUnits(ref.newUnits());
		
		System.out.println(terr[3].getUnits());
		
	}

}
