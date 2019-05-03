

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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class polyButton extends Application {

	Polygon[] polygon = new Polygon[19];
	Territory[] ters = new Territory[19];
	Player[] players = new Player[2];
	Label[] unitText = new Label[19];
	Button endPhase = new Button();
	Button confirm = new Button();
	Button start = new Button();
	Reinforce r = new Reinforce();
	ChoiceBox<Integer> numofDiceA = new ChoiceBox<>();
	ChoiceBox<Integer> numofDiceD = new ChoiceBox<>();
	ChoiceBox<Integer> numUnits = new ChoiceBox<>();
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

	
	
	@Override
	public void start(Stage stage) {

		// arrays for polygon, territories and text are populated with objects
		for (int i = 0; i < 19; i++) {
			polygon[i] = new Polygon();
			ters[i] = new Territory();
			unitText[i] = new Label();
		}

		// manually changed colors of players but need an option for this
		players[0] = new Player(Color.BLUE);
		players[1] = new Player(Color.RED);

		// populates the points from territory class to polygon objects also creates
		// territory borders.
		for (int i = 0; i < ters[0].getPoints().length; i++) {
			polygon[i].getPoints().addAll(ters[i].getThePoints(i));
			polygon[i].setStroke(Color.BLACK);
			unitText[i].setLayoutX(ters[i].getLabelPoints(i, 0));
			unitText[i].setLayoutY(ters[i].getLabelPoints(i, 1));
			unitText[i].setText("0");
		}

		// for testing, gives territories to players
		for (int i = 0; i < 5; i += 2) {
			polygon[i].setFill(players[0].getpColor());
			players[0].terWon(i);
			ters[i].setTroops(5);
		}
		for (int i = 1; i < 5; i += 2) {
			polygon[i].setFill(players[1].getpColor());
			players[1].terWon(i);
			ters[i].setTroops(4);
		}
		

		// changes color of polygon when clicked
		for (int i = 0; i < 5; i++) {
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

	} // end start

	public static void main(String[] args) {
		launch(args);
	} /// end main

	// method for determining what happens when a polygon is clicked on.
	public void selection(Shape s, int index, Paint defaultColor) {
		s.setOnMouseClicked(e -> {
			if (phase != 2) {
				// user is able to select a territory that they own if the territory is
				if (players[pTurn].isOwned(index) && !selectOne) {
					polygon[index].setFill(Color.ORANGE);
					selectOne = true;
					terA = index;
					System.out.println("Territory " + index + " is selected first.");
				} else if (polygon[index].getFill() == Color.ORANGE && selectOne && terD == -1) {
					selectOne = false;
					terA = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				} else if (selectOne && !selectTwo && !players[pTurn].isOwned(index) && phase != 0 /* is ajacent */) {
					selectTwo = true;
					terD = index;
					polygon[index].setFill(Color.YELLOW);
					System.out.println("Territory " + index + " is selected second.");
					diceChoice(ters[terA].getTroops(), ters[terD].getTroops());
				} else if (selectOne && selectTwo && polygon[index].getFill() == Color.YELLOW) {
					selectTwo = false;
					terD = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				}
			}
			else {
				if (players[pTurn].isOwned(index) && !selectOne) {
					polygon[index].setFill(Color.ORANGE);
					selectOne = true;
					terA = index;
					System.out.println("Territory " + index + " is selected first.");
				} else if (polygon[index].getFill() == Color.ORANGE && selectOne && terD == -1) {
					selectOne = false;
					terA = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				} else if (selectOne && !selectTwo && players[pTurn].isOwned(index) /* is ajacent */) {
					selectTwo = true;
					terD = index;
					polygon[index].setFill(Color.YELLOW);
					System.out.println("Territory " + index + " is selected second.");
				} else if (selectOne && selectTwo && polygon[index].getFill() == Color.YELLOW) {
					selectTwo = false;
					terD = -1;
					polygon[index].setFill(defaultColor);
					System.out.println("Territory " + index + " is no longer selected");
				}
			}
			});
	}

	public void buttonHandler() {
		confirm.setOnMouseClicked(e -> {
			updateTers();
			if (phase == 0 && selectOne) {
				System.out.println("re time");
				if (re == -1) {
					re++;
					System.out.println("re time part 2");
					re = r.newUnits(players[pTurn].terNums(), 0);
					System.out.println("re is now " + re);
					troopsChoice(re, true);
					endPhase.setDisable(true);
				}
				else if (re > 0)  {
					re -= numUnits.getValue();
					ters[terA].battleResult(-numUnits.getValue());
					updateTers();
					dropClear();
					troopsChoice(re, true);
				}
				else {
					endPhase.setDisable(false);
					re = -1;
				}
				
			} else if (phase == 1 && selectOne && selectTwo) {
				if (ters[terA].getTroops() <= 1) {
					System.out.println("Cannot attack");
				}
				
				else {
					System.out.println(numofDiceA.getValue() + "" + numofDiceD.getValue());
					b.calculateBattle(numofDiceA.getValue(), numofDiceD.getValue());
					
					if (ters[terD].getTroops() <= 0) {
						System.out.println("Player " + players[pTurn] + " has won territory " + terD);
						for (int i = 0; i < players.length; i++) {
							if (players[i].isOwned(terD)) {
								players[i].terLost(terD);
							}
						}
						players[pTurn].terWon(terD);
						//for (int i = 0; i < players[0].)
						System.out.println();
						
					}
					
					System.out.println("Battle");
					System.out.println("Territory " + terA + " has " + ters[terA].getTroops() + "number of troops");
					System.out.println("Territory " + terD + " has " + ters[terD].getTroops() + "number of troops");
					//b.printArrays(numofDiceA.getValue(),numofDiceD.getValue());
					dropClear();
					ters[terA].battleResult(b.getAttackLoss());
					ters[terD].battleResult(b.getDefenseLoss());
					System.out.println("Territory " + terA + " has " + ters[terA].getTroops() + "number of troops");
					System.out.println("Territory " + terD + " has " + ters[terD].getTroops() + "number of troops");
				}

			} else if (phase == 2 && selectOne && selectTwo) {
				if (ters[terA].getTroops() > 1  && (ters[terA].getTroops() /*- change*/) >= 1) {
					ters[terA].battleResult(1);
					ters[terD].battleResult(-1);
					System.out.println("Territory has " + ters[terA].getTroops());
					System.out.println("Territory has " + ters[terD].getTroops());
	            }
	            else {
	                System.out.println ("There are not enough units to fortify this territory");
	            }
			}
		});

		endPhase.setOnMouseClicked(e -> {
			
			
			if (phase == 0) {
				++phase;
				System.out.println("It is now Player " + pTurn + "'s turn. It is the attack phase now.");
			}
			else if (phase == 1) {
				++phase;
				System.out.println("It is now Player " + pTurn + "'s turn. It is the fortify phase now.");
			}
			else if (phase == 2) {
				if ((pNum - 1) == pTurn && turn == 0) {
					phase = 0;
					pTurn = 0;
					System.out.println("It is now Player " + pTurn + "'s turn. It is the reinforce phase now.");
					turn++;
				}
				else if (turn == 0) {
					pTurn++;
					System.out.println("It is now Player " + pTurn + "'s turn. It is the attack phase now.");
					phase = 1;
				}
				else {
					phase = 0;
					pTurn++;
					pTurn %= pNum;
					System.out.println("It is now Player " + pTurn + "'s turn. It is the reinforce phase now.");
				}
			}
		});

	}

	public Scene updateMap() {

		endPhase.setLayoutX(500);
		endPhase.setLayoutY(300);
		confirm.setLayoutX(400);
		confirm.setLayoutY(300);
		start.setLayoutX(300);
		
		
		numofDiceA.setLayoutX(300);
		numofDiceA.setLayoutY(300);
		numofDiceD.setLayoutX(200);
		numofDiceD.setLayoutY(300);
		numUnits.setLayoutX(100);
		numUnits.setLayoutY(300);

		endPhase.setText("End phase");
		confirm.setText("Confirm");

		Group poly = new Group();
		poly.getChildren().addAll(polygon);

		Pane root = new Pane();
		root.getChildren().add(endPhase);
		root.getChildren().add(confirm);
		root.getChildren().add(poly);
		root.getChildren().addAll(unitText);
		root.getChildren().add(numofDiceA);
		root.getChildren().add(numofDiceD);
		root.getChildren().add(numUnits);
		Scene map = new Scene(root, 600, 500);
		return map;
	}
	
	public void updateTers() {
		for(int i = 0; i < 5; i++) {
			unitText[i].setText(Integer.toString(ters[i].getTroops()));
		}
	}
	
	public void diceChoice(int diceA, int diceB) {
		
			if(diceA == 1) {
				numofDiceA.getItems().clear();
			}
			else if (diceA == 2) {
				numofDiceA.getItems().addAll(1);
			}
			else if (diceA == 3) {
				numofDiceA.getItems().addAll(1, 2);
			}
			
			else {
				numofDiceA.getItems().addAll(1, 2, 3);
			}
		
			if(diceB == 1) {
				numofDiceD.getItems().addAll(1);
			}
			else {
				numofDiceD.getItems().addAll(1,2);
				}
		}

	public void troopsChoice(int troops, boolean re) {
		if (!re) {
			if (troops > 1) {
				for(int i = 1; i < troops; i++) {
					numUnits.getItems().add(i);
				}	
			}
		}
		else {
			for(int i = 1; i <= troops; i++) {
				numUnits.getItems().add(i);
			}
		}
		
	}
	
	public void dropClear() {
		numofDiceA.getItems().clear();
		numofDiceD.getItems().clear();
		numUnits.getItems().clear();
		
	}
	
} // end polyButton
