package warehouse.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

@SuppressWarnings("All")

public class Controller {

    @FXML
    private TableColumn<?, ?> buyPriceColumn;

    @FXML
    private ChoiceBox<?> choiceboxDB;

    @FXML
    private ChoiceBox<?> choiceboxSearch;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> leftColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<?, ?> sellPriceColumn;

    @FXML
    private TableColumn<?, ?> soldColumn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> vendorColumn;

    @FXML
    void addProduct(ActionEvent event) {

    }

    @FXML
    void changeDB(ActionEvent event) {

    }

    @FXML
    void checkSells(ActionEvent event) {

    }

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void editProduct(ActionEvent event) {

    }

    @FXML
    void searchOnType(ActionEvent event) {

    }

}