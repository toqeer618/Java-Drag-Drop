package rough;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
//import javafx.scene.control.Labeled;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class dynamicController {
	  @FXML
	    private FlowPane container ;

	    //private Label 
	    @FXML
	    private Label lab;
	    private List<Text> labels;
	    @FXML
	    private ListView<Text> lview;
	   // ObservableList<Text>observableList = FXCollections.observableList(labels);


	    private Text label;
	    @FXML
	    
	     void initialize() {
	        labels = new ArrayList<>();
	        for (int i = 1; i <= 10; i++) {
	             label=new Text("Lab1"+i); 
	             labels.add(label);
	             container.getChildren().add(label);
	            
	        }
	        hhh();
	    }
	    
	    private void hhh() {
	    	
	         label.setOnDragDetected(new EventHandler <MouseEvent>() {
	            public void handle(MouseEvent event) {
	             /* drag was detected, start drag-and-drop gesture*/
	                System.out.println("onDragDetected");
	                /* allow any transfer mode */
	                Dragboard db = label.startDragAndDrop(TransferMode.ANY);
	                
	                /* put a string on dragboard */
	                ClipboardContent content = new ClipboardContent();
	               // content.putString(container.getText());
	                //db.setContent(content);
	                
	                event.consume();
	            }
	        });
	    	//container.getChildren().
	        lab.setOnDragOver(new EventHandler <DragEvent>() {
	            public void handle(DragEvent event) {
	                /* data is dragged over the target */
	                System.out.println("onDragOver");
	                
	                /* accept it only if it is  not dragged from the same node 
	                 * and if it has a string data */
	                if (event.getGestureSource() != lab &&
	                        event.getDragboard().hasString()) {
	                    /* allow for both copying and moving, whatever user chooses */
	                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
	                }
	                
	                event.consume();
	            }
	        });

	        lab.setOnDragEntered(new EventHandler <DragEvent>() {
	            public void handle(DragEvent event) {
	                /* the drag-and-drop gesture entered the target */
	                System.out.println("onDragEntered");
	                /* show to the user that it is an actual gesture target */
	                if (event.getGestureSource() != lab &&
	                        event.getDragboard().hasString()) {
	                    lab.setTextFill(Color.GREEN);
	                }
	                
	                event.consume();
	            }
	        });

	        lab.setOnDragExited(new EventHandler <DragEvent>() {
	            public void handle(DragEvent event) {
	                /* mouse moved away, remove the graphical cues */
	                lab.setTextFill(Color.BLACK);
	                
	                event.consume();
	            }
	        });
	        
	        lab.setOnDragDropped(new EventHandler <DragEvent>() {
	            public void handle(DragEvent event) {
	                /* data dropped */
	                System.out.println("onDragDropped");
	                /* if there is a string data on dragboard, read it and use it */
	                Dragboard db = event.getDragboard();
	                boolean success = false;
	                if (db.hasString()) {
	                   lab.setText("helllo");
	                    success = true;
	                }
	                /* let the source know whether the string was successfully 
	                 * transferred and used */
	                event.setDropCompleted(success);
	                
	                event.consume();
	            }
	        });
	        label.setOnDragDone(new EventHandler <DragEvent>() {
	            public void handle(DragEvent event) {
	                /* the drag-and-drop gesture ended */
	                System.out.println("onDragDone");
	                /* if the data was successfully moved, clear it */
	                if (event.getTransferMode() == TransferMode.MOVE) {
	                   label.setVisible(false);
	                }
	                
	                event.consume();
	            }
	        });

	       
	    }
}
