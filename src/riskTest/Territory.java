package riskTest;

public class Territory implements TerritoryFinals {
	private int troops = 5;

	/*
	 * deducts troops from a territory's troop count after a battle. Also used for
	 * adding troops during reinforce and fortify by inputing a negative number as
	 * unit loss.
	 */
	public void battleResult(int unitLoss) {
		troops = troops - unitLoss;
	}

	/**
	 * @return the troops
	 */
	public int getTroops() {
		return troops;
	}

	/**
	 * @param troops
	 *            the troops to set
	 */
	public void setTroops(int troops) {
		this.troops = troops;
	}

	// method for getting the points for the polygons from the interface. See line
	// number 231 in polyButton.
	public Double[] getThePoints(int index) {
		Double[] temp = new Double[points[index].length];
		for (int i = 0; i < points[index].length; i++) {
			temp[i] = points[index][i];
		}
		return temp;
	}

	public Double[][] getPoints() {
		return points;
	}

	// gets the coordinates for the troop number labels of each territory.
	public Double getLabelPoints(int index, int xOrY) {
		Double[] temp = new Double[2];
		for (int i = 0; i < 2; i++) {
			temp[i] = labelPoints[index][i];
		}
		System.out.println(temp[xOrY]);
		return temp[xOrY];

	}

	// returns whether a territory is adjacent to another territory.
	public boolean isAdjacent(int a, int d) {

		return adjacency[a][d];

	}

}