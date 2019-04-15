import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Peter Silvestri
 * @date 4/15/2019
 *
 */
public class Battle {

	// Initialize attackValue and defenseValue arrayList
	static ArrayList<Integer> attackValue = new ArrayList<>();
	static ArrayList<Integer> defenseValue = new ArrayList<>();
	static int attackingUnits = Territory.getUnits(); // getUnits from territory A (attacking)
	static int defendingUnits = Territory.getUnits(); // getUnits from territory B (defending)

	public static int attackRoll() {
		// Declare variables
		int attackingDice = 0;

		// Clear values in arrayList in case of previous battles.
		attackValue.clear();
		defenseValue.clear();

		// Ask attacking player how many units they want to use
		System.out.println("How many dice would the attacker like to use?");

		// Determine number of attack dice rolled.
		Scanner scAtt = new Scanner(System.in);
		int confirmAttDice = scAtt.nextInt();
		scAtt.close();

		// Determine if the attacker input is valid
		if (confirmAttDice > 3) {
			System.out.println("The attacker may only use up to three dice.");
			return attackRoll();
		} else if (confirmAttDice < 1) {
			System.out.println("You need to assign at least one unit to attack.");
			return attackRoll();
		} else if (attackingUnits - confirmAttDice < 1) {
			System.out.println("There are not enough units in the territory to perform this action.");
			return attackRoll();
		} else {
			attackingDice = confirmAttDice - 1;
			System.out.println("The attacker will use " + attackingDice + " dice.");
			return attackingDice;
		}
	}

	public static int defenseRoll() {

		int defendingDice = 0;

		// Ask defending player how many units they want to use
		System.out.println("How many dice would the defender like to use?");

		// Determine number of defense dice rolled.
		Scanner scDef = new Scanner(System.in);
		int confirmDefDice = scDef.nextInt();
		scDef.close();

		// Determine if defender input is valid
		if (confirmDefDice > 2) {
			System.out.println("The defender can use a maximum of two dice");
			return defenseRoll();
		} else if (confirmDefDice < 1) {
			System.out.println("The defender must use at least one die.");
			return defenseRoll();
		} else {
			defendingDice = confirmDefDice;
			System.out.println("The defender will use " + defendingDice + " dice.");
			return defendingDice;
		}
	}

	public static void fight() {

		// Initialize Random for usage
		Random random = new Random();

		// Place dice results into attackValue and defenseValue arrayLists.
		// Dice roll will have random value between 1 and 6
		for (int i = 0; i < attackRoll(); i++) {
			int rollDice = random.nextInt(6);
			rollDice += 1;
			attackValue.add(rollDice);
		}

		for (int i = 0; i < defenseRoll(); i++) {
			int rollDice = random.nextInt(6);
			rollDice += 1;
			defenseValue.add(rollDice);
		}

		// Sort dice results from largest to smallest.
		Collections.sort(attackValue, Collections.reverseOrder());
		Collections.sort(defenseValue, Collections.reverseOrder());

		// Compare largest attack roll to largest defense roll.
		if (attackValue.get(0) > defenseValue.get(0)) {
			defendingUnits -= 1;
			Territory.setUnits(defendingUnits);
		} else if (attackValue.get(0) < defenseValue.get(0)) {
			attackingUnits -= 1;
			Territory.setUnits(attackingUnits);
		}

		// Compare next largest...
		if (attackValue.get(1) > defenseValue.get(1)) {
			defendingUnits -= 1;
			Territory.setUnits(defendingUnits);
		} else if (attackValue.get(1) < defenseValue.get(1)) {
			attackingUnits -= 1;
			Territory.setUnits(attackingUnits);
		}

		// Compare last...
		if (attackValue.get(2) > defenseValue.get(2)) {
			defendingUnits -= 1;
			Territory.setUnits(defendingUnits);
		} else if (attackValue.get(2) < defenseValue.get(2)) {
			attackingUnits -= 1;
			Territory.setUnits(attackingUnits);
		}

	}
}