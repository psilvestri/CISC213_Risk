package riskTest;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class polyButton extends Application {

	Polygon[] polygon = new Polygon[19];
	Territory[] ters = new Territory[19];
	ArrayList<Player> players = new ArrayList<Player>();
	Label[] unitText = new Label[19];
	Label console = new Label();
	Label attackD = new Label();
	Label defendD = new Label();
	Label something = new Label();
	Button endPhase = new Button();
	Button confirm = new Button();
	Reinforce r = new Reinforce();
	ChoiceBox<Integer> numofDiceA = new ChoiceBox<>();
	ChoiceBox<Integer> numofDiceD = new ChoiceBox<>();
	ChoiceBox<Integer> numUnits = new ChoiceBox<>();
	Line lineOne = new Line(725, 790, 1064, 420);
	Line lineTwo = new Line(650, 520, 825, 380);
	Line lineThree = new Line(725, 300, 750, 190);
	Line lineFour = new Line(450, 20, 740, 30);
	Battle b = new Battle();
	int pTurn = 0;
	int pNum = 2;
	int phase = 1;
	boolean selectOne = false;
	boolean selectTwo = false;
	int terA = -1;
	int terD = -1;
	int re = -1;
	int turn = 0;
	Stage window = new Stage();
	Stage popUp = new Stage();
	Stage winWin = new Stage();

	// for territory won
	ChoiceBox<Integer> moveUnits = new ChoiceBox<Integer>();
	Button confirmMove = new Button("Confirm");
	int newTroop = 0;

	// For startup
	Button startConfirm;
	String[] playerColors;
	ChoiceBox<String> startPlayers, colors;
	Text playerText, colorText;
	int playerCount;
	ArrayList[] playerTerritories;

	// constructor for polyButton
	public polyButton() {
		startConfirm = new Button("Confirm");
		startPlayers = new ChoiceBox<String>();
		colors = new ChoiceBox<String>();
		playerText = new Text("How many players?");
		colorText = new Text("Pick Player1's color.");
	}

	@Override
	public void start(Stage stage) {// Start of start screen

		// Sets the coordinates for the labels and drop boxes for the startup screen.
		playerText.setLayoutX(247);
		playerText.setLayoutY(40);

		colorText.setLayoutX(247);
		colorText.setLayoutY(145);

		colors.setLayoutX(266);
		colors.setLayoutY(150);

		startPlayers.setLayoutX(275);
		startPlayers.setLayoutY(55);

		startConfirm.setLayoutX(275);
		startConfirm.setLayoutY(250);

		Pane pane = new Pane();
		// Combo boxes get populated
		startPlayers.getItems().addAll("2", "3", "4");
		colors.getItems().addAll("Blue", "Yellow", "Green", "Red");

		// Event handler for the confirm button
		startConfirm.setOnMouseClicked(e -> {

			
			//Gets the starting player count and adds it to the player count
			//Also adds the corresponding color to the corresponding player
			if (startPlayers.getValue() != null && colors.getValue() != null && playerColors == null) {
				playerCount = Integer.parseInt(startPlayers.getValue());
				playerColors = new String[playerCount];
				playerColors[0] = colors.getValue();
				colors.getItems().remove(playerColors[0]);
				colorText.setText("Pick Player2's color.");
				//Loops, does the same thing, and checks if the colors have all been added
				//If they have, switch windows
			} else if (colors.getValue() != null && playerColors != null) {
				for (int i = 0; i < playerColors.length; i++) {
					if (playerColors[i] == null) {
						playerColors[i] = colors.getValue();
						colorText.setText("Pick Player" + (i + 2) + "'s color.");
						colors.getItems().remove(playerColors[i]);
						if (i == playerColors.length - 1) {
							displayGame(window); //switches windows
						}
						break;
					}
				}

			}

		});

		pane.getChildren().addAll(startConfirm, colors, startPlayers, playerText, colorText);

		Scene scene = new Scene(pane, 600, 300);
		window.setTitle("Risk Setup (Chess)");
		window.setScene(scene);
		window.show();

	} // end start screen

	private void winner(Stage stage, int t) {// Start of winning screen
		Pane pane = new Pane();
		Button btn = new Button();
		Label lbl = new Label();
		// button and label coordinates are set
		btn.setLayoutX(100);
		btn.setLayoutX(200);
		lbl.setLayoutX(100);
		lbl.setLayoutX(300);

		pane.getChildren().addAll(btn, lbl);
		// sets the text for label and button
		lbl.setText("Player " + t + " is the winner!");
		btn.setText("Okay");

		Scene scene = new Scene(pane, 500, 500);

		winWin.setTitle("You won!");
		winWin.setScene(scene);
		winWin.show();
		// event handler which closes the program once confirm is clicked.
		btn.setOnMouseClicked(e -> {
			System.exit(0);
		});
	}// End of winning screen

	private void terWonTroopMove(Stage stage) {// Start of troop movement popup.

		Pane pane = new Pane();
		// button and combobox coordinates set.
		confirmMove.setLayoutX(100);
		confirmMove.setLayoutY(100);
		moveUnits.setLayoutX(200);
		moveUnits.setLayoutX(200);

		/*
		 * Later in the code, terA and terD are reset to -1. We needed to create two
		 * local variables which copy terA and terD to avoid the reset.
		 */
		int a = terA;
		int d = terD;
		// troops from 1 to the number of troops in the territory - 1 are added to the
		// combobox.
		for (int i = 1; i < ters[terA].getTroops(); i++) {
			moveUnits.getItems().add(i);
		}
		// button and combobox are added to the pane
		pane.getChildren().addAll(confirmMove, moveUnits);

		Scene scene = new Scene(pane, 500, 500);
		popUp.setTitle("Move units to your new territory!");
		popUp.setScene(scene);
		popUp.show();
		// Event handler for the confirm button.
		confirmMove.setOnMouseClicked(e -> {
			// new troops is set to the value selected in the combo box.
			newTroop = moveUnits.getValue();
			moveUnits.getItems().clear();
			// removes the conquered territory from the previous owner's list of owned
			// territories.
			for (int i = 1; i < players.size(); i++) {
				if (players.get(i).isOwned(d)) {
					players.get(i).terLost(d);
				}
			}
			// adds conquered territory to the new owner's list of owned territories.
			players.get(pTurn).terWon(d);

			System.out.println(players.get(pTurn).isOwned(d));
			System.out.println("terA" + a + "terD" + d);
			/*
			 * battle result method is used to add troops to the new territory and remove
			 * the same number from the attacking territory.
			 */
			ters[a].battleResult(newTroop);
			ters[d].battleResult(-newTroop);
			popUp.hide();
			updateColors();
			updateTers();
			window.show();
		});
	}// end of move troops popup

	private void displayGame(Stage stage) {// start of display game

		
		
		// arrays for polygon, territories, and labels are populated with objects
		for (int i = 0; i < 19; i++) {
			polygon[i] = new Polygon();
			ters[i] = new Territory();
			unitText[i] = new Label();
		}
		// sets the number of players
		pNum = playerCount;
		// sets the colors of players
		for (int i = 0; i < playerCount; i++) {
			players.add(new Player(playerColors[i]));
		}

		/*
		 * sets the coordinates of the polygons and labels. Label text is set to the
		 * number of troops in that territory.
		 */
		for (int i = 0; i < ters[0].getPoints().length; i++) {
			polygon[i].getPoints().addAll(ters[i].getThePoints(i));
			polygon[i].setStroke(Color.BLACK);
			unitText[i].setLayoutX(ters[i].getLabelPoints(i, 0));
			unitText[i].setLayoutY(ters[i].getLabelPoints(i, 1));
			unitText[i].setText(Integer.toString(ters[i].getTroops()));
		}

		// loops for giving territories to players
		for (int i = 0; i < 19; i += playerCount) {
			polygon[i].setFill(players.get(0).getColor());
			players.get(0).terWon(i);
		}
		for (int i = 1; i < 19; i += playerCount) {
			polygon[i].setFill(players.get(1).getColor());
			players.get(1).terWon(i);
		}
		if (playerCount == 3) {
			for (int i = 2; i < 19; i += playerCount) {
				polygon[i].setFill(players.get(2).getColor());
				players.get(2).terWon(i);
			}
		} else if (playerCount == 4) {
			for (int i = 2; i < 19; i += playerCount) {
				polygon[i].setFill(players.get(2).getColor());
				players.get(2).terWon(i);
			}

			for (int i = 3; i < 19; i += playerCount) {
				polygon[i].setFill(players.get(3).getColor());
				players.get(3).terWon(i);
			}
		}
		// test code for simulating to the end of the game.
		/*
		 * for (int i = 1; i < 19; i++) { polygon[i].setFill(players.get(0).getColor());
		 * players.get(0).terWon(i); }
		 * 
		 * polygon[0].setFill(players.get(1).getColor()); players.get(1).terWon(0);
		 */

		// changes color of polygon when clicked
		for (int i = 0; i < 19; i++) {
			selection(polygon[i], i, polygon[i].getFill());
		}
		// handles the events for clicking the buttons to confirm and end phase.
		buttonHandler();

		// Setting title to the Stage
		stage.setTitle("Risk Test");

		// Adding scene to the stage
		stage.setScene(updateMap());

		// Displaying the contents of the stage
		stage.show();
	}// end display game

	public static void main(String[] args) {
		launch(args);
	} /// end main

	// Event handler for clicking on the polygons.
	public void selection(Shape s, int index, Paint defaultColor) {
		s.setOnMouseClicked(e -> {
			// code for selection if the game is not in the fortify phase.
			if (phase != 2) {
				/*
				 * first territory can only be selected if no territory has been selected yet
				 * and if the selected territory is owned by the player whose turn it is. Second
				 * territory can be selected only if one territory has been selected and the
				 * second territory is not owned by the player whose turn it is and if the
				 * second territory is adjacent to the first territory. A second territory
				 * cannot be selected if it is phase 0 (reinforce phase) because only one
				 * territory is required for reinforcement. When a territory is selected, its
				 * color is changed and its index is stored in either terA for the first
				 * territory or terD for the second territory. Territories can be unselected by
				 * clicking on them again. The unselecting a territory resets its color and its
				 * corresponding index is reset.
				 */
				if (players.get(pTurn).isOwned(index) && !selectOne) {
					polygon[index].setFill(Color.ORANGE);
					selectOne = true;
					terA = index;
					System.out.println("Territory " + index + " is selected first.");
				} else if (polygon[index].getFill() == Color.ORANGE && selectOne && terD == -1) {
					selectOne = false;
					terA = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				} else if (selectOne && !selectTwo && !players.get(pTurn).isOwned(index) && phase != 0
						&& ters[terA].isAdjacent(terA, index)) {
					selectTwo = true;
					terD = index;
					polygon[index].setFill(Color.PINK);
					System.out.println("Territory " + index + " is selected second.");
					diceChoice(ters[terA].getTroops(), ters[terD].getTroops());
				} else if (selectOne && selectTwo && polygon[index].getFill() == Color.PINK) {
					selectTwo = false;
					terD = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				}
			} // end outer if statement
				// code similar to above but for fortify phase.
			else {
				if (players.get(pTurn).isOwned(index) && !selectOne) {
					polygon[index].setFill(Color.ORANGE);
					selectOne = true;
					terA = index;
					System.out.println("Territory " + index + " is selected first.");
				} else if (polygon[index].getFill() == Color.ORANGE && selectOne && terD == -1) {
					selectOne = false;
					terA = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				} else if (selectOne && !selectTwo && players.get(pTurn).isOwned(index)
						&& ters[terA].isAdjacent(terA, index)) {
					selectTwo = true;
					terD = index;
					polygon[index].setFill(Color.PINK);
					System.out.println("Territory " + index + " is selected second.");
				} else if (selectOne && selectTwo && polygon[index].getFill() == Color.PINK) {
					selectTwo = false;
					terD = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				}
			} // end outer else statement
		});// end event handler
	}// end selection

	// event handler for button events
	public void buttonHandler() {
		// code for clicking the confirm button
		confirm.setOnMouseClicked(e -> {
			/*
			 * reinforce phase will only execute if a territory is selected and it is phase
			 * 0. re (the number of reinforcements for a player) starts at -1. It is then
			 * set to the correct number of reinforcements by using the newUnits method of
			 * the Reinforce class. The troopsChoice method is then called which fills the
			 * reinforce choicebox with the correct number of reinforcements. When the
			 * player confirms their choice, this event handler is called again and the
			 * choicebox is cleared and repopulated with the updated remaining
			 * reinforcements. This will continue until the remaining reinforcements reaches
			 * 0.
			 */
			if (phase == 0 && selectOne) {
				if (re == -1) {
					re++;
					re = r.newUnits(players.get(pTurn).terNums(), 0);
					troopsChoice(re, true);
					endPhase.setDisable(true);
				} else if (re > 0) {
					re -= numUnits.getValue();
					ters[terA].battleResult(-numUnits.getValue());
					updateTers();
					dropClear();
					troopsChoice(re, true);
				} else {
					endPhase.setDisable(false);
					re = -1;
				}

				// code for attack phase
			} else if (phase == 1 && selectOne && selectTwo) {
				if (ters[terA].getTroops() <= 1) {
					System.out.println("Cannot attack");
				}

				else {
					System.out.println(numofDiceA.getValue() + " " + numofDiceD.getValue());
					b.calculateBattle(numofDiceA.getValue(), numofDiceD.getValue());

					System.out.println("Battle");
					System.out.println("Territory " + terA + " has " + ters[terA].getTroops() + "number of troops");
					System.out.println("Territory " + terD + " has " + ters[terD].getTroops() + "number of troops");

					dropClear();
					// losses calculated from battle class are removed from troop count of attacking
					// and defending territories.
					ters[terA].battleResult(b.getAttackLoss());
					ters[terD].battleResult(b.getDefenseLoss());
					// if defending territory's troops reach 0, the attacker wins that territory
					if (ters[terD].getTroops() <= 0) {
						System.out.println("Player " + pTurn + " has won territory " + terD);
						System.out.println(terA + " " + terD);
						/*
						 * bellow method creates a popup window prompting the user to select the number
						 * of troops to move to their new territory.
						 */
						terWonTroopMove(popUp);
					}

					System.out.println("Territory " + terA + " has " + ters[terA].getTroops() + "number of troops");
					System.out.println("Territory " + terD + " has " + ters[terD].getTroops() + "number of troops");
					// territory colors and label text containing troop counts are updated.
					updateColors();
					updateTers();

				}

			} else if (phase == 2 && selectOne && selectTwo) {
				if (ters[terA].getTroops() > 1) {
					terWonTroopMove(popUp);
					ters[terA].battleResult(newTroop);
					ters[terD].battleResult(-newTroop);
					System.out.println("Territory has " + ters[terA].getTroops());
					System.out.println("Territory has " + ters[terD].getTroops());
					updateColors();
					updateTers();
				} else {
					System.out.println("There are not enough units to fortify this territory");
				}
			}
		});
		/*
		 * event handler for endPhase. Advances to the next phase (reinforce, battle,
		 * fortify) when clicked. When clicked during the fortify phase, the turn is
		 * incremented by one and the phase is reset to reinforce. The first player is
		 * also set as the player whose turn it is.
		 */
		endPhase.setOnMouseClicked(e -> {

			if (phase == 0) {
				++phase;
				System.out.println("It is now Player " + pTurn + "'s turn. It is the attack phase now.");
			} else if (phase == 1) {
				++phase;
				System.out.println("It is now Player " + pTurn + "'s turn. It is the fortify phase now.");
			} else if (phase == 2) {
				if ((pNum - 1) == pTurn && turn == 0) {
					phase = 0;
					pTurn = 0;
					System.out.println("It is now Player " + pTurn + "'s turn. It is the reinforce phase now.");
					turn++;
				} else if (turn == 0) {
					pTurn++;
					System.out.println("It is now Player " + pTurn + "'s turn. It is the attack phase now.");
					phase = 1;
				} else {
					phase = 0;
					pTurn++;
					pTurn %= pNum;
					System.out.println("It is now Player " + pTurn + "'s turn. It is the reinforce phase now.");
				}
			}
		});

	}// end button handler

	/*
	 * changes all of the colors to the color of the player who owns the territory.
	 * Used after a selection to reset the colors of the selected territories. Also
	 * used after a territory is won in the attack phase.
	 */
	public void updateColors() {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < pNum; j++) {
				if (players.get(j).isOwned(i)) {
					polygon[i].setFill(players.get(j).getColor());
				}
			}
		}
		winCheck();
		selectOne = false;
		selectTwo = false;
		terA = -1;
		terD = -1;
	}// end update colors

	// method for setting the scene of the game board.
	public Scene updateMap() {

		endPhase.setLayoutX(900);
		endPhase.setLayoutY(0);
		confirm.setLayoutX(1000);
		confirm.setLayoutY(0);

		numofDiceA.setLayoutX(300);
		numofDiceA.setLayoutY(25);
		numofDiceD.setLayoutX(200);
		numofDiceD.setLayoutY(25);
		numUnits.setLayoutX(100);
		numUnits.setLayoutY(25);
		
		defendD.setLayoutX(200);
		defendD.setLayoutY(0);
		attackD.setLayoutX(300);
		attackD.setLayoutY(0);
		something.setLayoutX(90);
		something.setLayoutY(0);
		
		defendD.setText("Defend Dice");
		attackD.setText("Attack Dice");
		something.setText("Number of Units");
		
		lineOne.getStrokeDashArray().addAll(25d, 10d);
		lineTwo.getStrokeDashArray().addAll(25d, 10d);
		lineThree.getStrokeDashArray().addAll(25d, 10d);
		lineFour.getStrokeDashArray().addAll(25d, 10d);

		endPhase.setText("End phase");
		confirm.setText("Confirm");

		Group poly = new Group();
		poly.getChildren().addAll(polygon);

		console.setLayoutX(1500);
		console.setLayoutY(500);
		
		
		Pane root = new Pane();
		root.getChildren().addAll(lineOne, lineTwo, lineThree, lineFour);
		root.getChildren().add(endPhase);
		root.getChildren().add(confirm);
		root.getChildren().add(poly);
		root.getChildren().addAll(unitText);
		root.getChildren().add(numofDiceA);
		root.getChildren().add(numofDiceD);
		root.getChildren().add(numUnits);
		root.getChildren().addAll(console, attackD, defendD, something);
		Scene map = new Scene(root, 1400, 500);
		return map;
	}// end update map

	// Updates the troop numbers in the labels. Used after troops are moved or after
	// a battle.
	public void updateTers() {
		for (int i = 0; i < 19; i++) {
			unitText[i].setText(Integer.toString(ters[i].getTroops()));
		}
	}

	/*
	 * Determines the number of dice an attacker or defender can chose based off of
	 * how many troops are in the corresponding territory.
	 */
	public void diceChoice(int diceA, int diceB) {
		numofDiceA.getItems().clear();
		numofDiceD.getItems().clear();

		if (diceA == 1) {
			numofDiceA.getItems().clear();
		} else if (diceA == 2) {
			numofDiceA.getItems().addAll(1);
		} else if (diceA == 3) {
			numofDiceA.getItems().addAll(1, 2);
		}

		else {
			numofDiceA.getItems().addAll(1, 2, 3);
		}

		if (diceB == 1) {
			numofDiceD.getItems().addAll(1);
		} else {
			numofDiceD.getItems().addAll(1, 2);
		}
	}// end diceChoice

	// fills the choice box used for reinforcing.
	public void troopsChoice(int troops, boolean re) {
		if (!re) {
			if (troops > 1) {
				for (int i = 1; i < troops; i++) {
					numUnits.getItems().add(i);
				}
			}
		} else {
			for (int i = 1; i <= troops; i++) {
				numUnits.getItems().add(i);
			}
		}

	} // end troops choice
		// clears all choice boxes.

	public void dropClear() {
		numofDiceA.getItems().clear();
		numofDiceD.getItems().clear();
		numUnits.getItems().clear();

	}

	// checks for win condition. Launches the winner popup if there is a window.
	public void winCheck() {
		for (int i = 0; i < pNum; i++) {
			if (players.get(i).terNums() == 19) {
				window.hide();
				winner(winWin, i);

			}
		}
	}

} // end polyButton