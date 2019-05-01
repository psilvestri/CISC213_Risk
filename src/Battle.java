

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Owner
 *
 */
public class Battle {

	ArrayList<Integer> attack = new ArrayList<Integer>();
	ArrayList<Integer> defense = new ArrayList<Integer>();
	private int attackLoss;
	private int defenseLoss;

	// method called when new attack is initialized
	public void newAttack(int atk, int def) {
		Random rand = new Random();
		Integer num = 0;
		// previous values cleared
		attackLoss = 0;
		defenseLoss = 0;
		attack.clear();
		defense.clear();
		// attack and defense arrays filled with random values 1 - 6
		for (int i = 0; i < atk; i++) {
			attack.add(rand.nextInt(5) + 1);
		}
		for (int i = 0; i < def; i++) {
			defense.add(rand.nextInt(5) + 1);
		}

		// attack array sorted
		for (int i = 0; i < atk; i++) {
			for (int j = 0; j < atk - 1; j++) {
				if (attack.get(i) > attack.get(j)) {
					num = attack.get(i);
					attack.set(i, attack.get(j));
					attack.set(j, num);
				}
			}
		}

		// defense array sorted
		for (int i = 0; i < def; i++) {
			for (int j = 0; j < def; j++) {
				if (defense.get(i) > defense.get(j)) {
					num = defense.get(i);
					defense.set(i, attack.get(j));
					defense.set(j, num);
				}
			}
		}
	}

	// method for printing the arrays for testing
	public void printArrays() {
		for (int i = 0; i < 3; i++) {
			System.out.println(attack.get(i));
		}
		for (int i = 0; i < 2; i++) {
			System.out.println(defense.get(i));
		}
	}

	// method for calculating the battle results. Number of attack and defense dice
	// used are inputed into the method.
	public void calculateBattle(int atkDice, int defDice) {
		// the maximum amount of attacks is equal to the number of defense dice so the
		// for
		// loop is executed defDice number of times.
		newAttack(atkDice, defDice);
		for (int i = 0; i < defDice; i++) {
			if (attack.get(i) > defense.get(i)) {
				defenseLoss++;
			} else if (attack.get(i) < defense.get(i)) {
				attackLoss++;
			} else if (attack.get(i) == defense.get(i)) {
				attackLoss++;
			}
		}
	}

	// Getters and setters
	public int getAttackLoss() {
		return attackLoss;
	}

	public void setAttackLoss(int attackLoss) {
		this.attackLoss = attackLoss;
	}

	public int getDefenseLoss() {
		return defenseLoss;
	}

	public void setDefenseLoss(int defenseLoss) {
		this.defenseLoss = defenseLoss;
	}

}
