

public class Territory implements TerritoryFinals {
	private int troops = 0;

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

	// method for getting the points for the polygons from the interface.
	public Double[] getPoints(int index) {
		// Temporary solution will not work with dynamic number of points per polygon.
		Double[] temp = new Double[8];
		for (int i = 0; i < 8; i++) {
			temp[i] = points[index][i];
		}
		return temp;
	}

}
