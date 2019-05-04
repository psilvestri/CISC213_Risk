

public class Territory implements TerritoryFinals {
	private int troops = 10;

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
	public Double[] getThePoints(int index) {
		// Temporary solution will not work with dynamic number of points per polygon.
		Double[] temp = new Double[points[index].length];
		for (int i = 0; i < points[index].length; i++) {
			temp[i] = points[index][i];
		}
		return temp;
	}
	
	public Double[][] getPoints(){
		return points;
	}
	
	public Double getLabelPoints(int index, int xOrY) {
		Double[] temp = new Double[2];
		for (int i = 0; i < 2; i++) {
			temp[i] = labelPoints[index][i];
		}
		System.out.println(temp[xOrY]);
		return temp[xOrY];
		
	}
	
	public boolean isAdjacent(int a, int d) {
		
		return adjacency[a][d];
		
	}

}
