package fx_examples;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.Group; 
import javafx.scene.shape.Polygon; 
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent; 
import javafx.event.EventHandler;

public class MorePoly extends Application {

	@Override
	public void start(Stage stage) {
		//Creating a Polygon 
	    Polygon territory1 = new Polygon();  
	    Polygon territory2 = new Polygon();  
	    Polygon territory3 = new Polygon();
	    Polygon territory4 = new Polygon();
	    
	      //Adding coordinates to the polygon 
	    territory1.getPoints().addAll(new Double[]{ //setpoint for shape
	    		  
	    			//400 , 200
	    		

	    		140.0, 125.0,	// Connecting corner
	    		50.0, 42.0,		// Connecting corner
	    		243.0, 30.0,	// Connecting corner
	    		225.0, 63.0,	// Connecting corner
	    		250.0, 70.0,	// Connecting corner
	    		
	    		
	    		
	    		  
	    		  
	      });
	    
	   territory2.getPoints().addAll(new Double[] 
		{
				25.0, 50.0,
				50.0, 42.0,		//Connecting corner
				140.0, 125.0,	//Connecting corner
				25.0, 127.0
	    
	    });
	    
	    territory3.getPoints().addAll(new Double[]
	    {
	    		243.0, 30.0,
	    		225.0, 63.0,
	    		250.0, 70.0,
	    		278.0, 89.0,
	    		289.0, 15.0
	    });
	    
	    territory4.getPoints().addAll(new Double[]
	    {
    		
	    		278.0, 89.0,
	    		250.0, 70.0,
	    		140.0, 125.0,
	    		264.0, 100.0
	    		


	    });
	    
	    territory1.setFill(Color.PINK);
	    
	    territory1.setStroke(Color.BLACK);
	    territory2.setFill(Color.BLUE);
	    territory2.setStroke(Color.BLACK);
	    territory3.setFill(Color.ORANGE);
	    territory3.setStroke(Color.BLACK);
	    territory4.setFill(Color.RED);
	    territory4.setStroke(Color.BLACK);
	    
	      //Creating the mouse event handler 
	      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent e) { 
	                if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
	                	
	                	System.out.println("Mouse Pressed");
	                } 
	                else if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
	                	System.out.println(e.getSource().toString());
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
	      territory1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	      territory2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	      territory3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	      territory4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  

	      //Creating a Group object  
	      Group root = new Group(territory1, territory2, territory3, territory4); 
	         
	      //Creating a scene object 
	      //Scene scene = new Scene(root, 600, 300);  //*******************might need to fix
	      
	      Scene scene = new Scene(root, 400, 200);
	      
	      //**********************************************************************************GTG
	      //Setting title to the Stage 
	      stage.setTitle("Drawing a Polygon"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	      
	      //Displaying the contents of the stage 
	      stage.show(); 

	    
	    
	}  // end main

	public static void main(String[] args) {
		launch(args);
	}
}