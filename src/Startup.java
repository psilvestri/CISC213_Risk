//Zachary Lippincott 
//4/30/19

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Startup extends Application {

	private Button confirm;
	private String[] playerColors;
	private ChoiceBox<String> players, colors;
	private Text playerText, colorText;
	private int playerCount;
	private ArrayList[] playerTerritories;
	private boolean done = false;

	public Startup() throws Exception {
		confirm = new Button("Confirm");
		players = new ChoiceBox<String>();
		colors = new ChoiceBox<String>();
		playerText = new Text("How many players?");
		colorText = new Text("Pick Player1's color.");
	}

	
	public Stage show() {
		
		Stage stage = new Stage();
		
		stage.initModality(Modality.APPLICATION_MODAL);

		playerText.setLayoutX(247);
		playerText.setLayoutY(40);

		colorText.setLayoutX(247);
		colorText.setLayoutY(145);

		Pane pane = new Pane();
		players.getItems().addAll("2", "3", "4");
		colors.getItems().addAll("Blue", "Yellow", "Green", "Red");

		colors.setLayoutX(266);
		colors.setLayoutY(150);

		players.setLayoutX(275);
		players.setLayoutY(55);

		confirm.setLayoutX(275);
		confirm.setLayoutY(250);

		confirm.setOnMouseClicked(e -> {

			if (players.getValue() != null && colors.getValue() != null && playerColors == null) {

				playerCount = Integer.parseInt(players.getValue());
				playerColors = new String[playerCount];
				playerColors[0] = colors.getValue();
				colors.getItems().remove(playerColors[0]);
				colorText.setText("Pick Player2's color.");
			} else if (colors.getValue() != null && playerColors != null) {
				for (int i = 0; i < playerColors.length; i++) {
					if (playerColors[i] == null) {
						playerColors[i] = colors.getValue();
						colorText.setText("Pick Player" + (i + 2) + "'s color.");
						colors.getItems().remove(playerColors[i]);
						if (i == playerColors.length - 1) {
							stage.hide();
							done = true;

						}
						break;
					}
				}

			}

		});

		pane.getChildren().addAll(confirm, colors, players, playerText, colorText);

		Scene scene = new Scene(pane, 600, 300);
		
		stage.setTitle("Risk Setup (Chess)");
		stage.setScene(scene);
		
		return stage;
	}

	// Getters and setters below!

	public String[] getColors() {
		return playerColors; 
	}


	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public boolean getDone() {
		return done;
	}


	@Override
	public void start(Stage stage) throws Exception {
		stage.show();

		
	}

	
	
}
