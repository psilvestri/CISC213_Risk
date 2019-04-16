import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoardTest extends Application {
	
	public void start(Stage primaryStage) throws Exception {
	    //create a pane to hold the image views
	    Pane pane = new HBox(10);
	    pane.setPadding(new Insets(0,0,0,0));

	    //create the image to be used!
	    Image Myimage = new Image("file:src\\Risk_game_map.png");

	    //set some custom properties and add an image
	    ImageView imageView = new ImageView(Myimage);
	    imageView.setFitHeight(628);
	    imageView.setFitWidth(1227);
	    pane.getChildren().add(imageView);

	    //add the second image view with this image and no custom properties
	    pane.getChildren().add(new ImageView(Myimage));

	    Scene scene = new Scene(pane, 1227, 628);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}

	public static void main(String[] args) {
	    Application.launch(args);
	}

}
