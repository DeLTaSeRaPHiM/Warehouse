package warehouse.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import warehouse.config.Warehouse;

//@SuppressWarnings("All")

public class Controller {

    @FXML
    private TableColumn<Warehouse, String> buyPriceColumn;

    @FXML
    private ChoiceBox choiceboxDB;

    @FXML
    private ChoiceBox choiceboxSearch;

    @FXML
    private TableColumn<Warehouse, String> idColumn;

    @FXML
    private TableColumn<Warehouse, String> categoryColumn;

    @FXML
    private TableColumn<Warehouse, String> nameColumn;

    @FXML
    private TableColumn<Warehouse, String> quantityColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<Warehouse, String> sellPriceColumn;

    @FXML
    private TableColumn<Warehouse, String> soldColumn;

    @FXML
    private TableView<Warehouse> tableView;

    @FXML
    private TableColumn<Warehouse, String> typeColumn;

    @FXML
    private TableColumn<Warehouse, String> vendorColumn;


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