
/**
 * 
 */
import java.util.*;
/**
 * @author David Amos
 *
 */
public class Player implements GameObject{

	Scanner scan;
	
	//this color will actual pertain to this player
	String PlayerColor;
	
	static ArrayList<String> ColorList;
	//integer to represent the users selection of a color based of an array list
	int choice;
	
	//each player will have a value to determine their turn order
	int TurnOrder;
	
	int territoriesOwned;
	
	int unitsOwned;
	
	boolean didWin = false;
	
	boolean myTurn = false;
	
	String ColorPicked;
	
	
	public Player() {
		
		scan = new Scanner(System.in);
		ColorList = new ArrayList<>();	
		
		ColorList.add("Red");
		ColorList.add("Blue");
		ColorList.add("Green");
		ColorList.add("Yellow");
		ColorList.add("Brown");
		ColorList.add("Pink");
	}
	
	public void setColorSelection(int ColorSelection) {
		
		//set ColorPicked
		ColorPicked = ColorList.get(ColorSelection);
		
		//remove the color from the list so it no longer available to other players
		ColorList.remove(ColorSelection);
	}
	
	
	//set integer with selection/index from the List of Colors
	public void setColorChoiceInt(ArrayList<String> ColorList) {

		//prompt color choice
		System.out.println("Please pick one of the following colors");
		
		//user will choose color/index from ColorList
		int index = 0;
		
		//Enter index to select color
		for (String colors : ColorList) {
		
		//prompt/display colors
		//Enter index to select color
		System.out.println("Enter " + index + " to select " + colors);

		index++; 
		}
		
		//allow user to enter index for the color they would like
		choice = scan.nextInt();
		scan.close();
	}
	
	//sends back the ColorChoice integer to be removed in Game Settings
	public int getColorChoiceInt() {
		return choice;
	}

	public void setPlayerColor(String color) {
		PlayerColor = color;
	}
	
	public String getPlayerColor() {
		return PlayerColor;
	}
	
	public void setTurnOrder(int TurnOrder) {
		this.TurnOrder = TurnOrder;
	}
	
	public int getTurnOrder() {
		return TurnOrder;
	}

	/**
	 * @return the territoriesOwned
	 */
	public int getTerritoriesOwned() {
		return territoriesOwned;
	}
	/**
	 * @param territoriesOwned the territoriesOwned to set
	 */
	public void setTerritoriesOwned(int territoriesOwned) {
		this.territoriesOwned = territoriesOwned;
	}
	/**
	 * @return the unitsOwned
	 */
	public int getUnitsOwned() {
		return unitsOwned;
	}
	/**
	 * @param unitsOwned the unitsOwned to set
	 */
	public void setUnitsOwned(int unitsOwned) {
		this.unitsOwned = unitsOwned;
	}
	/**
	 * @return the didWin
	 */
	public boolean isDidWin() {
		return didWin;
	}
	/**
	 * @param didWin the didWin to set
	 */
	public void setDidWin(boolean didWin) {
		this.didWin = didWin;
	}
	/**
	 * @return the myTurn
	 */
	public boolean isMyTurn() {
		return myTurn;
	}
	/**
	 * @param myTurn the myTurn to set
	 */
	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}
	
	// Method to check if the player has won
	private void checkWin(int territoryAmount)
	{
		// If they hold all the territories they win
		if (territoryAmount == 42)	// Compares their amount of owned territories to the max possible
		{
			didWin = true;	// Sets didWin to true
		}
		
	}
	/* (non-Java doc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
//		return "Player [" + (playerColor != null ? "playerColor=" + playerColor + ", " : "") + "turn=" + turn
//				+ ", territoriesOwned=" + territoriesOwned + ", unitsOwned=" + unitsOwned + ", didWin=" + didWin
//				+ ", myTurn=" + myTurn + "]";
		
		return "The cake is a lie";
	}
	
}
