/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewdataselection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Narayan G. Maharjan <me@ngopal.com.np>
 */
public class TableViewDataDemoController {
    /**
     * For the data transformation
     */
    public static DataFormat dataFormat = new DataFormat("mydata");
 
    private Label label;
    private String Value;
    @FXML
    private ToggleGroup selectionGrp;

    @FXML
    private ComboBox<TableColumn<Person, ?>> colSelect;

    @FXML
    private RadioButton cellRadio, rowRadio;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private FlowPane listView;
   

    @FXML
    private TableColumn<Person, String> addressCol;

    @FXML
    private TableColumn<Person, Gender> genderCol;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> phoneCol;

    @FXML
    private TableColumn<Person, String> snCol;

    @FXML
    private TableView<Person> tableView;

    ObservableList<Integer> selectedIndexes = FXCollections.observableArrayList();
    private List<Label> labels;

    @FXML
    void initialize() {
    	 labels = new ArrayList<>();
	        for (int i = 1; i <= 10; i++) {
	             label=new Label("Lab1"+i); 
	             label.setFont(Font.font(null, FontWeight.BOLD, 30));	
	             label.setStyle("-fx-border-color: Red");
	             labels.add(label);
	             listView.getChildren().add(label);
	             
	        }

        // changed to multiple selection mode
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // set cell value factories
        setCellValueFactories();

        //set Dummy Data for the TableView
        tableView.setItems(getData());

        //ListView items bound with selection index property of tableview
      //  listView.setItems(selectedIndexes);

        //change listview observable list
        tableView.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                selectedIndexes.setAll(change.getList());
            }
        });

        //Setting the items for columns selection
        colSelect.setItems(tableView.getColumns());
        for (TableColumn c : colSelect.getItems()) {
            setCellColumnSelection(c);
        }

        //add listener and update of selection type
        colSelect.valueProperty().addListener(new ChangeListener<TableColumn<Person, ?>>() {
            @Override
            public void changed(
                      ObservableValue<? extends TableColumn<Person, ?>> ov,
                      TableColumn<Person, ?> t,
                      final TableColumn<Person, ?> t1) {
                if (t1 != null) {
                    if (cellRadio.isSelected()) {
                       // setCellSelection();
                    }
                }

            }
        });


        //For showing the column name properly
        colSelect.setConverter(new StringConverter<TableColumn<Person, ?>>() {
            @Override
            public String toString(TableColumn<Person, ?> t) {
                return t.getText();
            }

            @Override
            public TableColumn<Person, ?> fromString(String string) {
                for (TableColumn<Person, ?> t : colSelect.getItems()) {
                    if (t.getText().equals(string)) {
                        return t;
                    }
                }
                return null;
            }
        });

        //the radio buttons change property listener [Row/Cell] selection
        selectionGrp.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(
                      ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
                if (t1 == cellRadio) {
                    setCellSelection();
                } else {
                    setRowSelection();
                }

            }
        });
        //Stricting the Column selection
        colSelect.disableProperty().bind(cellRadio.selectedProperty().not());

        //set the Row Factory of the table
        setRowFactory();

        //Set row selection as default
        setRowSelection();
    }

    private void setCellValueFactories() {   	
    	
        snCol.setCellValueFactory(new PropertyValueFactory("sn"));
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory("gender"));
        phoneCol.setCellValueFactory(new PropertyValueFactory("phone"));
        addressCol.setCellValueFactory(new PropertyValueFactory("address"));
        ///
        
        
        ///
         label.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                //System.out.println("onDragDetected");
                
                /* allow any transfer mode */
                Dragboard db = label.startDragAndDrop(TransferMode.ANY);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(label.getText());
                db.setContent(content);
                Value=label.getText();
                
                event.consume();
            }
        });
    	
    	///
        tableView.setOnDragOver(new EventHandler <DragEvent>() {
             public void handle(DragEvent event) {
                 /* data is dragged over the target */
                 System.out.println("onDragOver");
                 
                 /* accept it only if it is  not dragged from the same node 
                  * and if it has a string data */
                 if (event.getGestureSource() != tableView &&
                         event.getDragboard().hasString()) {
                     /* allow for both copying and moving, whatever user chooses */
                     event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                 }
                 
                 event.consume();
             }
         });
    	 
    	//
        tableView.setOnDragEntered(new EventHandler <DragEvent>() {
             public void handle(DragEvent event) {
                 /* the drag-and-drop gesture entered the target */
                 System.out.println("onDragEntered");
                 /* show to the user that it is an actual gesture target */
                 if (event.getGestureSource() != tableView &&
                         event.getDragboard().hasString()) {
                	 //tabView.setFill(Color.GREEN);
                 }
                 
                 event.consume();
             }
         });
    	 //
    	 
        tableView.setOnDragExited(new EventHandler <DragEvent>() {
             public void handle(DragEvent event) {
                 /* mouse moved away, remove the graphical cues */
            	 //tabView.setFill(Color.BLACK);
                 
                 event.consume();
             }
         });
    	 //
        tableView.setOnDragDropped(new EventHandler <DragEvent>() {
             public void handle(DragEvent event) {
                 /* data dropped */
                 System.out.println("onDragDropped");
                 /* if there is a string data on dragboard, read it and use it */
                 Dragboard db = event.getDragboard();
                 boolean success = false;
                 if (db.hasString()) {
                	 tableView.getSelectionModel().cellSelectionEnabledProperty().setValue(true);
                	 
                	
                	 success = true;
                 }
                 /* let the source know whether the string was successfully 
                  * transferred and used */
                 event.setDropCompleted(success);
                 
                 event.consume();
             }
         });
    	 //
    	 
       
        
    }

    /**
     * Change the cell selection boolean value of TableView
     */
    public void setRowSelection() {
        tableView.getSelectionModel().clearSelection();
        tableView.getSelectionModel().setCellSelectionEnabled(false);
    }

    /**
     * Change the cell selection boolean value of TableView
     */
    public void setCellSelection() {
        tableView.getSelectionModel().clearSelection();
        tableView.getSelectionModel().setCellSelectionEnabled(true);

    }

    /**
     * Set Row Factory for the TableView
     */
    public void setRowFactory() {
        tableView.setRowFactory(new Callback<TableView<Person>, TableRow<Person>>() {
            @Override
            public TableRow<Person> call(TableView<Person> p) {
                final TableRow<Person> row = new TableRow<Person>();
                row.setOnDragEntered(new EventHandler<DragEvent>() {
                    @Override
                    public void handle(DragEvent t) {
                        //setSelection(row);
                    }
                });

                row.setOnDragDetected(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        if (rowRadio.isSelected()) {
                            Dragboard db = row.getTableView().startDragAndDrop(TransferMode.COPY);
                            ClipboardContent content = new ClipboardContent();
                            content.put(dataFormat, "XData");
                            db.setContent(content);
                            setSelection(row);
                            t.consume();
                        }
                    }
                });
                
                row.setOnDragDropped(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* data dropped */
                        System.out.println("onDragDropped");
                        /* if there is a string data on dragboard, read it and use it */
                        Dragboard db = event.getDragboard();
                        boolean success = false;
                        if (db.hasString()) {
                       	 tableView.getSelectionModel().cellSelectionEnabledProperty().setValue(true);
                       	 
                       	setSelection(row);
                       	 success = true;
                        }
                        /* let the source know whether the string was successfully 
                         * transferred and used */
                        event.setDropCompleted(success);
                        
                        event.consume();
                    }
                });
                return row;
            }
        });
    }

    /**
     * This function helps to make the Cell Factory for specific TableColumn
     *
     * @param col
     */
    public void setCellColumnSelection(final TableColumn col) {
        col.setCellFactory(new Callback<TableColumn<Person, ?>, TableCell<Person, ?>>() {
            @Override
            public TableCell<Person, ?> call(
                      TableColumn<Person, ?> p) {
                final TableCell cell = new TableCell() {
                    @Override
                    protected void updateItem(Object t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.toString());
                        }
                    }
                };

                cell.setOnDragEntered(new EventHandler<DragEvent>() {
                    @Override
                    public void handle(DragEvent t) {
                        setSelection(cell, col);
                    }
                });

                cell.setOnDragDetected(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        if (cellRadio.isSelected() && colSelect.getValue() == col) {
                            Dragboard db = cell.getTableView().startDragAndDrop(TransferMode.COPY);
                            ClipboardContent content = new ClipboardContent();
                            content.put(dataFormat, "XData");
                            db.setContent(content);
                            setSelection(cell, col);
                            t.consume();
                        }
                    }
                });
                return cell;

            }
        });
    }

    /**
     * For the changes on table cell selection used only on the TableCell selection mode
     *
     * @param cell
     */
    private void setSelection(IndexedCell cell) {
        if (rowRadio.isSelected()) {
            if (cell.isSelected()) {
                System.out.println("False");
                tableView.getSelectionModel().clearSelection(cell.getIndex());
            } else {
                System.out.println("true");
                tableView.getSelectionModel().select(cell.getIndex());
            }
        }

    }

    /**
     * For the changes on the table row selection used only on TableRow selection mode
     *
     * @param cell
     * @param col
     */
    private void setSelection(IndexedCell cell, TableColumn col) {
        if (cellRadio.isSelected()) {
            if (cell.isSelected()) {
                System.out.println("False enter");
                tableView.getSelectionModel().clearSelection(cell.getIndex(), col);
            } else {
                System.out.println("Select");
                
                cell.setOnDragDropped(new EventHandler <DragEvent>() {
                    public void handle(DragEvent event) {
                        /* data dropped */
                        System.out.println("onDragDropped");
                        /* if there is a string data on dragboard, read it and use it */
                        Dragboard db = event.getDragboard();
                        boolean success = false;
                        if (db.hasString()) {
                       	 tableView.getSelectionModel().cellSelectionEnabledProperty().setValue(true);
                       	 
                       	cell.setText(Value);
                       	 success = true;
                        }
                        /* let the source know whether the string was successfully 
                         * transferred and used */
                        event.setDropCompleted(success);
                        
                        event.consume();
                    }
                });

                tableView.getSelectionModel().select(cell.getIndex(), col);
            }
        }
    }

    /**
     * Provides the Dummy Data for this application in string format
     *
     * @param length
     * @return String
     */
    public String getDummyText(int length) {
        String most = "abdflntiso";
        String alpha = "abcdefghijkmopqrstuvwxyz";
        StringBuffer b = new StringBuffer();
        int chars = 0;
        for (int i = 0; i < length; i++) {
            if (chars > 2 && chars > Math.random() * 10) {
                b.append(" ");
                chars = 0;
                continue;
            }
            if (chars == 0 || i % 2 == 0) {
                b.append(most.charAt((int)(Math.random() * most.length())));
            } else {
                b.append(alpha.charAt((int)(Math.random() * alpha.length())));
            }
            chars++;
        }
        return b.toString();
    }

    /**
     * Provides the dummy String
     *
     * @param length
     * @return
     */
    public String getDummyDigits(int length) {

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; i++) {
            b.append((int)(Math.random() * 9));
        }
        return b.toString();
    }

    /**
     * Provides the dummy Person data.
     *
     * @return
     */
    public ObservableList<Person> getData() {
        String[] names = new String[]{"Room-V", "Room-VIII", "Room-IX", "Room-X", "Room-XI", "RoomXII", "Khyber-Lab", "Hassan Abidi Lab"};

        ObservableList<Person> persons = FXCollections.observableArrayList();
        for (int i = 1; i < 8; i++) {
            Person p = new Person();
            p.setSn(names[i]);
//            p.setName(getDummyText(15));
//            p.setAddress(getDummyText(15));
//            p.setPhone(getDummyDigits(9));
//            p.setGender(Gender.values()[i % 3]);
           persons.add(p);
        }
        return persons;
    }
}
