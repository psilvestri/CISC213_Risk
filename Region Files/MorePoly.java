

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
	    Polygon oldTerritory = new Polygon();  
	    Polygon newTerritory = new Polygon();
	    Polygon vermont = new Polygon();
		
	    
	      //Adding coordinates to the polygon 
	    oldTerritory.getPoints().addAll(new Double[]{ 
	    		  178.0, 21.0,
	    		  159.0, 35.0,
	    		  152.0, 34.0,
	    		  149.0, 25.0,
	    		  142.0, 25.0,
	    		  126.0, 71.0,
	    		  127.0, 84.0,
	    		  123.0, 100.0,
	    		  126.0, 111.0,
	    		  128.0, 115.0,
	    		  126.0, 121.0,
	    		  125.0, 123.0,
	    		  126.0, 126.0,
	    		  118.0, 138.0,
	    		  120.0, 146.0,
	    		  117.0, 146.0,
	    		  115.0, 154.0,
	    		  110.0, 153.0,
	    		  107.0, 155.0,
	    		  138.0, 252.0,
	    		  139.0, 255.0,
	    		  147.0, 259.0,
	    		  147.0, 264.0,
	    		  153.0, 268.0,
	    		  157.0, 261.0,
	    		  161.0, 245.0,
	    		  160.0, 240.0,
	    		  165.0, 232.0,
	    		  164.0, 224.0,
	    		  168.0, 219.0,
	    		  171.0, 223.0,
	    		  172.0, 212.0,
	    		  175.0, 207.0,
	    		  188.0, 205.0,
	    		  196.0, 205.0,
	    		  198.0, 197.0,
	    		  199.0, 180.0,
	    		  202.0, 171.0,
	    		  207.0, 175.0,
	    		  207.0, 181.0,
	    		  217.0, 183.0,
	    		  217.0, 170.0,
	    		  253.0, 145.0,
	    		  262.0, 134.0,
	    		  250.0, 121.0,
	    		  245.0, 123.0,
	    		  236.0, 103.0,
	    		  220.0, 100.0,
	    		  199.0, 31.0,
	      }); 
	    
	    //Adding coordinates to the polygon 
	    newTerritory.getPoints().addAll(new Double[]{ 
	    		107.0, 157.0,
	    		104.0, 159.0,
	    		97.0, 179.0,
	    		96.0, 189.0,
	    		101.0, 200.0,
	    		87.0, 217.0,
	    		89.0, 228.0,
	    		86.0, 255.0,
	    		84.0, 260.0,
	    		87.0, 274.0,
	    		88.0, 286.0,
	    		87.0, 293.0,
	    		89.0, 300.0,
	    		93.0, 303.0,
	    		136.0, 294.0,
	    		148.0, 280.0,
	    		152.0, 279.0,
	    		153.0, 269.0,
	    		147.0, 263.0,
	    		146.0, 259.0,
	    		139.0, 254.0,
	    		137.0, 246.0,
	    		
	      }); 
	    
	    vermont.getPoints().addAll(new Double[]{ 
	    		  95.0, 175.0,
	    		  28.0, 193.0,
	    		  29.0, 198.0,
	    		  29.0, 201.0,
	    		  31.0, 206.0,
	    		  31.0, 213.0,
	    		  37.0, 220.0,
	    		  38.0, 231.0,
	    		  38.0, 245.0,
	    		  44.0, 260.0,
	    		  44.0, 268.0,
	    		  47.0, 266.0,
	    		  51.0, 269.0,
	    		  59.0, 307.0,
	    		  61.0, 310.0,
	    		  92.0, 304.0,
	    		  87.0, 299.0,
	    		  88.0, 293.0,
	    		  86.0, 271.0,
	    		  84.0, 260.0,
	    		  86.0, 251.0,
	    		  88.0, 231.0,
	    		  87.0, 217.0,
	    		  101.0, 201.0,
	    		  100.0, 196.0,
	    		  96.0, 191.0,
	    		  98.0, 183.0,
	    		  95.0, 177.0,
	  
	      }); 
	    
	    
	    oldTerritory.setFill(Color.BURLYWOOD);
	    newTerritory.setFill(Color.BURLYWOOD);
	    
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
	      oldTerritory.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	      newTerritory.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	        
	      //Creating a Group object  
	      Group root = new Group(newTerritory, oldTerritory, vermont); 
	         
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 300);  
	      
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
