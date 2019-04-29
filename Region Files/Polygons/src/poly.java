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

public class poly extends Application {

	@Override
	public void start(Stage stage) {
		//Creating a Polygon 
	    Polygon rwhh = new Polygon();  
	    Polygon ig = new Polygon();  
	    Polygon eagles = new Polygon();
	    
	      //Adding coordinates to the polygon 
	    rwhh.getPoints().addAll(new Double[]{ //setpoint for shape
	    		  
	    			//400 , 200
	    		
	    		245.0, 175.0,//I
	    		250.0, 150.0,//J
	    		269.0, 125.0,//A
	    		288.0, 150.0,//B
	    		315.0, 125.0,//C
	    		340.0, 150.0,//D
	    		360.0, 125.0,//E
	    		385.0, 150.0,//F        
	    		385.0, 195.0,//G
	    		200.0, 195.0,//H 
	    		  
	    		  
	      });
	    
	    ig.getPoints().addAll(new Double[] {
	    		
	    		250.0, 85.0,//16
	    		222.0, 65.0,//15 top left
	    		252.0, 60.0,//14
	    		266.0, 5.0,//14aa
	    		280.0, 60.0,//13
	    		294.0, 5.0,//12
	    		308.0, 60.0,//11
	    		326.0, 5.0,//10
	    		346.0, 60.0,//9
	    		370.0, 5.0,//8 top right
	    		385.0, 60.0,//new point Z
	    		385.0, 149.9,//7 bottom right
	    		360.0, 124.9,//6
	    		340.0, 149.9,//5
	    		315.0, 124.9,//4
	    		288.0, 149.9,//3
	    		269.0, 124.9,//2
	    		250.0, 149.9,//1 bottom left
	    });
	    
	    
	    //Adding coordinates to the polygon 
	    eagles.getPoints().addAll(new Double[]{ 
	    		
	    		82.0, 98.0,//b
	    		122.0, 88.0,
	    		168.0, 68.0, //
	    		162.0, 90.0,//r
	    		200.0, 65.0,//e
	    		191.0, 90.0,//p
	    		222.0, 65.2,//q ******* 15
	    		249.9, 85.0,//s ******* 16
	    		249.7, 148.0,//e
	    		73.0, 153.0,//l
	    		30.0, 180.0,//g
	    		56.0, 135.0,//a
	    		5.0, 155.0,//e
	      });
	    
	    
	    rwhh.setFill(Color.BURLYWOOD);
	    ig.setFill(Color.RED);
	    eagles.setFill(Color.BLACK);
	    
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
	      rwhh.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	      ig.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);  
	      eagles.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
	        
	      //Creating a Group object  
	      Group root = new Group(rwhh, ig, eagles); 
	         
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
