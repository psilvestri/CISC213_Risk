

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.paint.Color;

public class Player {

	private Color pColor = null;
	private ArrayList<Integer> tersOwned = new ArrayList<Integer>();
	int unplayedUnits = 0;

	Player(Color color) {
		setpColor(color);
	}

	public Color getpColor() {
		return pColor;
	}

	public void setpColor(Color pColor) {
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
	
	public int terNums () {
		return tersOwned.size();
	}

}
