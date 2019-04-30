package fx_examples;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.Group; 
import javafx.scene.shape.Polygon; 
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent; 
import javafx.event.EventHandler;

public class polyButton extends Application {

	@Override
	public void start(Stage stage) {
		//Creating a Polygon 
	      Polygon polygon = new Polygon();  
	       
	      //Adding coordinates to the polygon 
	      polygon.getPoints().addAll(new Double[]{ 
	    		  200.0, 50.0, 
	    		   400.0, 50.0, 
	    		   450.0, 150.0,          
	    		   400.0, 250.0, 
	    		   200.0, 250.0,                   
	    		   150.0, 150.0, 
	      }); 
	          
	            
	      //Creating the mouse event handler 
	      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent e) { 
	                if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
	                	System.out.println("Mouse Pressed");
	                } 
	                else if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
	                	System.out.println("Mouse CLICKED");
	                	
	                }
	                else
	                {
	                	System.out.println("Mouse Not Pressed");
	                	System.out.println(e.toString());
	                	System.out.println(e.getEventType());
	                }
	         } 
	      };  
	      //Registering the event filter 
	      polygon.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	      
	        
	      //Creating a Group object  
	      Group root = new Group(polygon); 
	         
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 300);  
	      
	      //Setting title to the Stage 
	      stage.setTitle("Drawing a Polygon"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	      
	      //Displaying the contents of the stage 
	      stage.show(); 
	      
	}  // end start

	public static void main(String[] args) {
		launch(args);
	}  /// end main
}  // end polyButton
