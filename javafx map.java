

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group; 
import javafx.scene.shape.Polygon; 
import javafx.scene.input.MouseEvent; 
import javafx.event.EventHandler;

public class polyButton extends Application {

	@Override
	public void start(Stage stage) {
		//Creating a Polygon 
	      Polygon polygon = new Polygon();  
	      Polygon polygon2 = new Polygon();
	      Polygon polygon3 = new Polygon();
	      Polygon polygon4 = new Polygon();
	       
	      //Adding coordinates to the polygon 
	      /*polygon.getPoints().addAll(new Double[]{ 
	    		  200.0, 50.0, 
	    		   400.0, 50.0, 
	    		   450.0, 150.0,          
	    		   400.0, 250.0, 
	    		   200.0, 250.0,                   
	    		   150.0, 150.0, 
	      }); */
	      
	      polygon.getPoints().addAll(new Double[]{ 
	    		  0.0, 185.0,
	    		  50.0, 0.0,
	    		  150.0, 0.0,
	    		  150.0, 200.0,
	    		  100.0, 200.0,
	    		  100.0, 185.0
	      });
	      
	      polygon.setFill(Color.BLUE);
	          
	      
	      polygon2.getPoints().addAll(new Double[]{ 
	    		  150.0, 200.0,//200
	    		  150.0, 0.0,//0
	    		  300.0, 0.0,//0
	    		  300.0, 175.0,//175
	    		  200.0, 175.0,//175
	    		  200.0, 200.0//200
	      });
	      
	      polygon2.setFill(Color.YELLOW);
	      
	      
	      
	      polygon3.getPoints().addAll(new Double[]{ 
	    		  300.0, 175.0,//175
	    		  300.0, 0.0,//0
	    		  375.0, 0.0,//0
	    		  450.0, 120.0,//120
	    		  435.0, 175.0//175
	      });
	      
	      polygon3.setFill(Color.GREEN);
	      
	      
	      
	      polygon4.getPoints().addAll(new Double[]{ 
	    		  200.0, 175.0,
	    		  435.0, 175.0,
	    		  525.0, 490.0,//500,500
	    		  490.0, 525.0,//480, 515
	    		  440.0, 510.0,
	    		  365.0, 250.0,//350.0, 250.0
	    		  315.0, 210.0,
	    		  200.0, 200.0//200.0, 210.0
	      });
	      
	      polygon4.setFill(Color.RED);
	          
	            
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
	      polygon2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
	      polygon3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
	      polygon4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
	        
	      //Creating a Group object  
	      Group root = new Group(polygon, polygon2, polygon3, polygon4); 
	         
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 600);  
	      
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
