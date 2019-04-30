import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Map extends Application {

	@Override
	public void start(Stage stage) {
		// Creating a Polygon
		Polygon alpha = new Polygon();
		Polygon beta = new Polygon();
		Polygon charlie = new Polygon();
		Polygon delta = new Polygon();
		Polygon echo = new Polygon();
		Polygon foxtrot = new Polygon();
		Polygon golf = new Polygon();
		Polygon hotel = new Polygon();
		Polygon india = new Polygon();
		Polygon juliett = new Polygon();
		Polygon kilo = new Polygon();
		Polygon lima = new Polygon();
		Polygon mike = new Polygon();
		Polygon november = new Polygon();
		Polygon oscar = new Polygon();
		Polygon papa = new Polygon();
		Polygon quebec = new Polygon();
		Polygon romeo = new Polygon();
		Polygon sierra = new Polygon();
		Polygon tango = new Polygon();
		Polygon uniform = new Polygon();
		Polygon victor = new Polygon();
		Polygon whiskey = new Polygon();

		// Adding coordinates to the polygon
		// Orange
		alpha.getPoints().addAll(
				new Double[] { 250.0, 60.0, 350.0, 50.0, 450.0, 20.0, 550.0, 150.0, 490.0, 215.0, 400.0, 250.0, });

		beta.getPoints().addAll(
				new Double[] { 400.0, 250.0, 490.0, 215.0, 575.0, 300.0, 510.0, 370.0, 450.0, 400.0, 350.0, 400.0 });

		charlie.getPoints()
				.addAll(new Double[] { 510.0, 370.0, 575.0, 300.0, 620.0, 350.0, 630.0, 375.0, 575.0, 390.0 });

		delta.getPoints().addAll(new Double[] { 490.0, 215.0, 550.0, 150.0, 725.0, 300.0, 675.0, 325.0, 650.0, 300.0,
				625.0, 310.0, 650.0, 340.0, 620.0, 350.0 });

		// Blue
		echo.getPoints()
				.addAll(new Double[] { 100.0, 250.0, 100.0, 260.0, 110.0, 300.0, 100.0, 340.0, 200.0, 485.0, 250.0,
						400.0, 210.0, 360.0, 210.0, 350.0, 220.0, 350.0, 220.0, 320.0, 160.0, 320.0, 180.0, 280.0,
						180.0, 270.0, 170.0, 250.0 });

		foxtrot.getPoints().addAll(new Double[] { 190.0, 150.0, 170.0, 180.0, 170.0, 250.0, 180.0, 270.0, 180.0, 280.0,
				160.0, 320.0, 220.0, 320.0, 220.0, 350.0, 260.0, 350.0, 260.0, 150.0 });

		golf.getPoints().addAll(
				new Double[] { 260.0, 150.0, 260.0, 350.0, 290.0, 350.0, 290.0, 320.0, 400.0, 250.0, 320.0, 150.0 });

		// Yellow
		lima.getPoints().addAll(new Double[] { 740.0, 30.0, 860.0, 20.0, 900.0, 100.0, 800.0, 140.0, 740.0, 100.0 });

		mike.getPoints().addAll(new Double[] { 860.0, 20.0, 1060.0, 60.0, 1100.0, 130.0, 1030.0, 150.0, 950.0, 200.0,
				960.0, 120.0, 900.0, 100.0, });

		november.getPoints().addAll(
				new Double[] { 750.0, 190.0, 800.0, 140.0, 900.0, 100.0, 960.0, 120.0, 950.0, 200.0, 880.0, 260.0 });

		oscar.getPoints()
				.addAll(new Double[] { 1100.0, 130.0, 1030.0, 150.0, 950.0, 200.0, 880.0, 260.0, 1090.0, 280.0 });

		// Purple
		papa.getPoints()
				.addAll(new Double[] { 940.0, 375.0, 880.0, 260.0, 1043.0, 275.0, 1025.0, 315.0, 1050.0, 320.0, });

		quebec.getPoints().addAll(new Double[] { 825.0, 300.0, 880.0, 260.0, 940.0, 375.0, 825.0, 380.0 });

		romeo.getPoints()
				.addAll(new Double[] { 1043.0, 275.0, 1025.0, 315.0, 1050.0, 320.0, 1078.0, 340.0, 1090.0, 280.0 });

		sierra.getPoints().addAll(new Double[] { 1078.0, 340.0, 1050.0, 320.0, 940.0, 375.0, 1064.0, 420.0 });

		// Red
		tango.getPoints().addAll(
				new Double[] { 200.0, 485.0, 250.0, 400.0, 350.0, 400.0, 350.0, 600.0, 300.0, 600.0, 300.0, 585.0 });

		uniform.getPoints().addAll(
				new Double[] { 350.0, 600.0, 350.0, 400.0, 510.0, 370.0, 500.0, 575.0, 400.0, 575.0, 400.0, 600.0 });

		victor.getPoints()
				.addAll(new Double[] { 500.0, 575.0, 510.0, 370.0, 575.0, 390.0, 650.0, 520.0, 635.0, 575.0 });

		whiskey.getPoints().addAll(new Double[] { 400.0, 575.0, 635.0, 575.0, 725.0, 790.0, 690.0, 825.0, 640.0, 810.0,
				565.0, 650.0, 515.0, 610.0, 400.0, 600.0 });

		// Setting fill colors
		alpha.setFill(Color.ORANGE);
		beta.setFill(Color.ORANGE);
		charlie.setFill(Color.ORANGE);
		delta.setFill(Color.ORANGE);
		echo.setFill(Color.BLUE);
		foxtrot.setFill(Color.BLUE);
		golf.setFill(Color.BLUE);
		lima.setFill(Color.YELLOW);
		mike.setFill(Color.YELLOW);
		november.setFill(Color.YELLOW);
		oscar.setFill(Color.YELLOW);
		papa.setFill(Color.PURPLE);
		quebec.setFill(Color.PURPLE);
		romeo.setFill(Color.PURPLE);
		sierra.setFill(Color.PURPLE);
		tango.setFill(Color.RED);
		uniform.setFill(Color.RED);
		victor.setFill(Color.RED);
		whiskey.setFill(Color.RED);

		// Setting polygon borders
		alpha.setStroke(Color.BLACK);
		beta.setStroke(Color.BLACK);
		charlie.setStroke(Color.BLACK);
		delta.setStroke(Color.BLACK);
		echo.setStroke(Color.BLACK);
		foxtrot.setStroke(Color.BLACK);
		golf.setStroke(Color.BLACK);
		lima.setStroke(Color.BLACK);
		mike.setStroke(Color.BLACK);
		november.setStroke(Color.BLACK);
		oscar.setStroke(Color.BLACK);
		papa.setStroke(Color.BLACK);
		quebec.setStroke(Color.BLACK);
		romeo.setStroke(Color.BLACK);
		sierra.setStroke(Color.BLACK);
		tango.setStroke(Color.BLACK);
		uniform.setStroke(Color.BLACK);
		victor.setStroke(Color.BLACK);
		whiskey.setStroke(Color.BLACK);

		// Create connecting lines
		Line line1 = new Line(725, 790, 1064, 420);
		line1.getStrokeDashArray().addAll(25d, 10d);

		Line line2 = new Line(650, 520, 825, 380);
		line2.getStrokeDashArray().addAll(25d, 10d);

		Line line3 = new Line(725, 300, 750, 190);
		line3.getStrokeDashArray().addAll(25d, 10d);

		Line line4 = new Line(450, 20, 740, 30);
		line4.getStrokeDashArray().addAll(25d, 10d);

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
		alpha.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		beta.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		charlie.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		delta.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		echo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		foxtrot.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		golf.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		lima.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		mike.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		november.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		oscar.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		papa.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		quebec.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		romeo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		sierra.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		tango.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		uniform.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		victor.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		whiskey.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

		// Creating a Group object
		Group root = new Group(beta, alpha, charlie, delta, echo, foxtrot, golf, november, oscar, mike, lima, papa,
				quebec, romeo, sierra, tango, uniform, victor, whiskey, line1, line2, line3, line4);

		// Creating a scene object
		Scene scene = new Scene(root, 1200, 900);

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
