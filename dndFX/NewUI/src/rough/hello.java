package rough;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;

import javafx.application.Application;
import javafx.beans.NamedArg;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import tableviewdataselection.TableViewDataSelection;

public class hello extends Application {
	
	 
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("dynamicText.fxml")); 
		Scene scene = new Scene(root);
        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
