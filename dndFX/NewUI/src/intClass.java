import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class intClass extends Application{
	final Text source = new Text(50, 100, "DRAG ME");
	final Text target = new Text(300, 100, "DROP HERE");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		 Parent root = FXMLLoader.load(getClass().getResource("table2.fxml")); 
	        Scene scene=new Scene(root,300,300);  
	        //root.getChildren().addAll(target, source); 
	       // root.getChildren().add(target);
	        primaryStage.setScene(scene);  
	        primaryStage.setTitle("Drag and Drop Example.");  
	        primaryStage.show();
		
	}

}
