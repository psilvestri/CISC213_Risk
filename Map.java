import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Map extends Application {

	@Override
	public void start(Stage stage) {
		// Creating a Polygon
		Polygon berksCounty = new Polygon();
		Polygon chesterCounty = new Polygon();
		Polygon delawareCounty = new Polygon();
		Polygon montgomeryCounty = new Polygon();

		// Adding coordinates to the polygon
		berksCounty.getPoints().addAll(
				new Double[] { 50.0, 60.0, 150.0, 50.0, 250.0, 20.0, 350.0, 150.0, 290.0, 215.0, 200.0, 250.0, });
		berksCounty.setStyle("-fx-border-color: black");

		// Adding coordinates to the polygon
		chesterCounty.getPoints().addAll(
				new Double[] { 200.0, 250.0, 290.0, 215.0, 375.0, 300.0, 310.0, 370.0, 250.0, 400.0, 150.0, 400.0 });

		// Adding coordinates to the polygon
		delawareCounty.getPoints()
				.addAll(new Double[] { 310.0, 370.0, 375.0, 300.0, 420.0, 350.0, 430.0, 375.0, 375.0, 390.0 });

		// Adding coordinates to the polygon
		montgomeryCounty.getPoints().addAll(new Double[] { 290.0, 215.0, 350.0, 150.0, 525.0, 300.0, 475.0, 325.0,
				450.0, 300.0, 425.0, 310.0, 450.0, 340.0, 420.0, 350.0 });

		berksCounty.setFill(Color.BLUE);
		chesterCounty.setFill(Color.RED);
		delawareCounty.setFill(Color.YELLOW);
		montgomeryCounty.setFill(Color.ORANGE);

		// Creating the mouse event handler
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {

					System.out.println("Mouse Pressed");

				} else if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
					System.out.println(e.getSource().toString());
					System.out.println("Mouse CLICKED");

				} else {
					System.out.println("Mouse Not Pressed");
					System.out.println(e.toString());
					System.out.println(e.getEventType());
				}
			}
		};

		// Registering the event filter
		berksCounty.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		chesterCounty.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		delawareCounty.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		montgomeryCounty.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

		// Creating a Group object
		Group root = new Group(chesterCounty, berksCounty, delawareCounty, montgomeryCounty);

		// Creating a scene object
		Scene scene = new Scene(root, 800, 500);

		// Setting title to the Stage
		stage.setTitle("Drawing a Polygon");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();

	} // end main

	public static void main(String[] args) {
		launch(args);
	}
}
