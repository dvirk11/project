package Gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BooksearchResultsController {

    @FXML
    private AnchorPane AnchSerchBook;

    @FXML
    private ImageView Image;

    @FXML
    private TableView<?> Tableview;

    @FXML
    private TableColumn<?, ?> Title;

    @FXML
    private TableColumn<?, ?> Genre;

    @FXML
    private TableColumn<?, ?> Author;

    @FXML
    private TableColumn<?, ?> Description;

    @FXML
    private TableColumn<?, ?> tableofcontents;

    @FXML
    private Label SearchBookresultsLabel;
    
    
    public void initialize() {
    
    }

}

    
 


