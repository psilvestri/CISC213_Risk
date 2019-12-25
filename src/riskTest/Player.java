package riskTest;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.paint.Color;

public class Player {

	private String pColor = null;
	private ArrayList<Integer> tersOwned = new ArrayList<Integer>();
	// Colors go blue, yellow, green, red
	private final Color[] COLORS = { Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED };

	Player(String color) {
		setpColor(color);
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	// Adds the territory won to the owned territory array list then the array list
	// is sorted.
	public void terWon(int terID) {
		tersOwned.add(terID);
		Collections.sort(tersOwned);
	}

	/*
	 * method uses binary search to search the array list of territories owned for
	 * the territory lost. The territory is then removed from the owned territory
	 * array list.
	 */
	public void terLost(int terID) {
		int low = 0;
		int high = tersOwned.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (tersOwned.get(mid) < terID) {
				low = mid + 1;
			} else if (tersOwned.get(mid) > terID) {
				high = mid - 1;
			} else if (tersOwned.get(mid) == terID) {
				tersOwned.remove(mid);
				break;
			}
		}
	}

	/*
	 * Binary search is used to search the sorted owned territory arraylist. Returns
	 * true if the territory is found.
	 */
	public boolean isOwned(int terID) {
		int low = 0;
		int high = tersOwned.size() - 1;
		int runs = 0;
		while (low <= high && runs < tersOwned.size()) {
			int mid = (low + high) / 2;
			if (tersOwned.get(mid) < terID) {
				low = mid + 1;
			} else if (tersOwned.get(mid) > terID) {
				high = mid - 1;
			} else if (tersOwned.get(mid) == terID) {
				return true;
			}
			runs++;
		}
		return false;
	}

	// returns the number of territories owned.
	public int terNums() {
		return tersOwned.size();
	}

	// sets the color of the player.
	public Color getColor() {
		if (pColor.equalsIgnoreCase("blue")) {
			return COLORS[0];
		} else if (pColor.equalsIgnoreCase("yellow")) {
			return COLORS[1];
		} else if (pColor.equalsIgnoreCase("green")) {
			return COLORS[2];
		} else if (pColor.equalsIgnoreCase("red")) {
			return COLORS[3];
		} else {
			return Color.BLACK;
		}
	}

}