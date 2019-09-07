import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class table implements Initializable{
	@FXML private Label lable1;
@FXML private TableView<timeTable> tabView;
@FXML private TableColumn<timeTable, String> slot1;
@FXML private TableColumn<timeTable, String> slot2;
@FXML private TableColumn<timeTable, String> slot3;
@FXML private TableColumn<timeTable, String> slot4;
@FXML private TableColumn<timeTable, String> slot5;

final ObservableList<timeTable> data = FXCollections.observableArrayList(
	    new timeTable("Jacob", "Smith", "jacob.smith@example.com", "alpha", "jdjdj"),
	    new timeTable("Isabella", "Johnson", "isabella.johnson@example.com", "alpha", "jdjdj"),
	    new timeTable("Ethan", "Williams", "ethan.williams@example.com", "alpha", "jdjdj"),
	    new timeTable("Emma", "Jones", "emma.jones@example.com", "alpha", "jdjdj"),
	    new timeTable("Michael", "Brown", "michael.brown@example.com", "alpha", "jdjdj")
	);

public void hello(ActionEvent e)
{System.out.println("jdjjdjdjdjd");
	}
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	slot1.setCellValueFactory(new PropertyValueFactory<timeTable,String>("slot1"));
	slot2.setCellValueFactory(new PropertyValueFactory<timeTable,String>("slot2"));
	slot3.setCellValueFactory(new PropertyValueFactory<timeTable,String>("slot3"));
	slot4.setCellValueFactory(new PropertyValueFactory<timeTable,String>("slot4"));
	slot5.setCellValueFactory(new PropertyValueFactory<timeTable,String>("slot5"));
	lable1.setText("Hello");
	tabView.setItems(data);
	lable1.setOnDragDetected(new EventHandler <MouseEvent>() {
        public void handle(MouseEvent event) {
            /* drag was detected, start drag-and-drop gesture*/
            //System.out.println("onDragDetected");
            
            /* allow any transfer mode */
            Dragboard db = lable1.startDragAndDrop(TransferMode.ANY);
            
            /* put a string on dragboard */
            ClipboardContent content = new ClipboardContent();
            content.putString(lable1.getText());
            db.setContent(content);
            
            event.consume();
        }
    });
	
	///
	 tabView.setOnDragOver(new EventHandler <DragEvent>() {
         public void handle(DragEvent event) {
             /* data is dragged over the target */
             System.out.println("onDragOver");
             
             /* accept it only if it is  not dragged from the same node 
              * and if it has a string data */
             if (event.getGestureSource() != tabView &&
                     event.getDragboard().hasString()) {
                 /* allow for both copying and moving, whatever user chooses */
                 event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
             }
             
             event.consume();
         }
     });
	 
	//
	 tabView.setOnDragEntered(new EventHandler <DragEvent>() {
         public void handle(DragEvent event) {
             /* the drag-and-drop gesture entered the target */
             System.out.println("onDragEntered");
             /* show to the user that it is an actual gesture target */
             if (event.getGestureSource() != tabView &&
                     event.getDragboard().hasString()) {
            	 //tabView.setFill(Color.GREEN);
             }
             
             event.consume();
         }
     });
	 //
	 
	 tabView.setOnDragExited(new EventHandler <DragEvent>() {
         public void handle(DragEvent event) {
             /* mouse moved away, remove the graphical cues */
        	 //tabView.setFill(Color.BLACK);
             
             event.consume();
         }
     });
	 //
	 tabView.setOnDragDropped(new EventHandler <DragEvent>() {
         public void handle(DragEvent event) {
             /* data dropped */
             System.out.println("onDragDropped");
             /* if there is a string data on dragboard, read it and use it */
             Dragboard db = event.getDragboard();
             boolean success = false;
             if (db.hasString()) {
            	 tabView.getSelectionModel().cellSelectionEnabledProperty().setValue(true);
            	 
            	
            	 success = true;
             }
             /* let the source know whether the string was successfully 
              * transferred and used */
             event.setDropCompleted(success);
             
             event.consume();
         }
     });
	 //
	 
	 tabView.setOnMouseReleased(new EventHandler <MouseEvent>() {
			

			@Override
			public void handle(MouseEvent event) {
				TableCell<timeTable,String> cell= new TableCell<>();
 				System.out.println(cell.isSelected());
			}
			
			
		});
	 //
}

}
