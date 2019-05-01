

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class polyButton extends Application {

	Polygon[] polygon = new Polygon[5];
	Territory[] ters = new Territory[5];
	Player[] players = new Player[2];
	Text[] units = new Text[5];
	Button endPhase = new Button();
	Button confirm = new Button();
	Battle b = new Battle();
	int pTurn = 0;
	int pNum = 2;
	int phase = 1;
	boolean selectOne = false;
	boolean selectTwo = false;
	int terA = -1;
	int terD = -1;

	
	
	@Override
	public void start(Stage stage) {

		// arrays for polygon, territories and text are populated with objects
		for (int i = 0; i < 5; i++) {
			polygon[i] = new Polygon();
			ters[i] = new Territory();
			units[i] = new Text();
		}

		// manually changed colors of players but need an option for this
		players[0] = new Player(Color.BLUE);
		players[1] = new Player(Color.RED);

		// populates the points from territory class to polygon objects also creates
		// territory borders.
		for (int i = 0; i < 5; i++) {
			polygon[i].getPoints().addAll(ters[i].getPoints(i));
			polygon[i].setStroke(Color.BLACK);
			units[i].setText(Integer.toString(ters[i].getTroops()));
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
			} else if (selectOne && selectTwo && polygon[index].getFill() == Color.YELLOW) {
				selectTwo = false;
				terD = -1;
				polygon[index].setFill(defaultColor);
				System.out.println("Territory " + index + " is no longer selected");
			}
		});
	}

	public void buttonHandler() {
		confirm.setOnMouseClicked(e -> {
			if (phase == 0 && selectOne) {
				// code for reinforce
			} else if (phase == 1 && selectOne && selectTwo) {
				// need functionality for inputing the number of dice for attacker and defender
				if (ters[terA].getTroops() <= 1) {
					System.out.println("Cannot attack");
				}
				
				else {
					b.calculateBattle(3, 2);

					System.out.println("Battle");
					System.out.println("Territory " + terA + " has " + ters[terA].getTroops() + "number of troops");
					System.out.println("Territory " + terD + " has " + ters[terD].getTroops() + "number of troops");
					b.printArrays();
					ters[terA].battleResult(b.getAttackLoss());
					ters[terD].battleResult(b.getDefenseLoss());
					System.out.println("Territory " + terA + " has " + ters[terA].getTroops() + "number of troops");
					System.out.println("Territory " + terD + " has " + ters[terD].getTroops() + "number of troops");
				}

			} else if (phase == 2 && selectOne && selectTwo) {

			}
		});

		endPhase.setOnMouseClicked(e -> {
			++phase;
			if (phase == 3) {
				phase = phase % 3;
				pTurn++;
				if (pTurn - 1 == players.length) {
					pTurn = 1;
				}
				System.out.println(phase);
				System.out.println("Player " + pTurn + " is going.");
			} else if (phase < 3) {
				phase = phase % 3;
				System.out.println(phase);
			}
		});

	}

	public Scene updateMap() {

		endPhase.setLayoutX(500);
		endPhase.setLayoutY(250);
		confirm.setLayoutX(400);
		confirm.setLayoutY(250);

		endPhase.setText("End phase");
		confirm.setText("Confirm");

		Group poly = new Group();
		poly.getChildren().addAll(polygon);

		Pane root = new Pane();
		root.getChildren().add(endPhase);
		root.getChildren().add(confirm);
		root.getChildren().add(poly);
		Scene map = new Scene(root, 600, 300);
		return map;
	}
} // end polyButton
