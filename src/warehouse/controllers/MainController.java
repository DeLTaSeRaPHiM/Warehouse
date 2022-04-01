package warehouse.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import warehouse.config.Warehouse;
import warehouse.database.DatabaseHandler;

import java.io.IOException;

//@SuppressWarnings("All")

public class MainController {

    @FXML
    private TableView<Warehouse> tableView;

    @FXML
    private TableColumn<Warehouse, String> purchasePriceColumn;

    @FXML
    private TableColumn<Warehouse, String> idColumn;

    @FXML
    private TableColumn<Warehouse, String> categoryColumn;

    @FXML
    private TableColumn<Warehouse, String> nameColumn;

    @FXML
    private TableColumn<Warehouse, String> quantityColumn;

    @FXML
    private TableColumn<Warehouse, String> retailPriceColumn;

    @FXML
    private TableColumn<Warehouse, String> sellPriceColumn;

    @FXML
    private TableColumn<Warehouse, String> typeColumn;

    @FXML
    private TableColumn<Warehouse, String> vendorColumn;

    @FXML
    private TextField searchField;

    @FXML
    private ChoiceBox choiceboxDB;

    @FXML
    private ChoiceBox choiceboxSearch;


    private DatabaseHandler databaseHandler = new DatabaseHandler();
    private ObservableList<Warehouse> dbTableList = FXCollections.observableArrayList();

    /**
     * Метод инициализации приложения
     */
    @FXML
    void initialize() {
        updateTable();
    }

    /**
     * Метод отображения окна добавления значений в базу данных
     */
    @FXML
    void addProduct(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/warehouse/windows/AddProductWindow.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    /**
     * Метод отображения окна редактирования значения в базе данных
     */
    @FXML
    void editProduct(ActionEvent event) {

    }

    /**
     * Метод сортировки и отображения базы данных по категории товара
     */
    @FXML
    void filterOnType(ActionEvent event) {

    }

    /**
     * Метод перехода к таблице продаж
     */
    @FXML
    void checkSells(ActionEvent event) {

    }

    /**
     * Метод удаления значения строки в таблице
     */
    @FXML
    void deleteProduct(ActionEvent event) {

    }

    /**
     * Метод поиска по выбранному типу
     */
    @FXML
    void searchOnType(ActionEvent event) {

    }

    /**
     * Метод для обновления содержимого главной таблицы
     */
    void updateTable(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        vendorColumn.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        retailPriceColumn.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));
        purchasePriceColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));

        dbTableList = databaseHandler.getProduct();
        tableView.setItems(dbTableList);
    }

}