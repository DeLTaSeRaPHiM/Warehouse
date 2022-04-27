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
import static warehouse.database.Configs.warehouseTemp;
import warehouse.database.DatabaseHandler;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

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
    private TableColumn<Warehouse, String> lastUpdateDateColumn;

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
     * Метод обновления таблицы
     */
    @FXML
    void updateTableData(ActionEvent event) {
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
        Warehouse warehouse;
        warehouse = tableView.getSelectionModel().getSelectedItem();

        if (warehouse != null) {
            warehouseTemp = warehouse;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/warehouse/windows/UpdateProductWindow.fxml"));

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
    }

    /**
     * Метод удаления значения строки в таблице
     */
    @FXML
    void deleteProduct(ActionEvent event) {
        Warehouse warehouse;
        warehouse = tableView.getSelectionModel().getSelectedItem();
        try {
            if (warehouse != null) {
                int id = warehouse.getId();
                databaseHandler.deleteRow(id);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        updateTable();
    }

    /**
     * Метод перехода к таблице продаж
     */
    @FXML
    void showDescription(ActionEvent event) {
        Warehouse warehouse;
        warehouse = tableView.getSelectionModel().getSelectedItem();

        LocalDate localDate = LocalDate.now();
        String stDate = localDate.toString();
        System.out.println(stDate);
    }

    /**
     * Метод сортировки и отображения базы данных по категории товара
     */
    @FXML
    void filterOnCategory(ActionEvent event) {
        String choice = (String) choiceboxDB.getValue();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        vendorColumn.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        purchasePriceColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        lastUpdateDateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdateDate"));

        if (!choice.matches("Все")) {
            dbTableList = databaseHandler.sortByCategory(choice);
            tableView.setItems(dbTableList);
        } else {
            updateTable();
        }

    }

    /**
     * Метод поиска по выбранному типу
     */
    @FXML
    void searchOnType(ActionEvent event) {
        String search = "%" + searchField.getText() + "%";
        String choice = (String) choiceboxSearch.getValue();
        System.out.println(search);

        if (search.equals("")) {
            updateTable();
        } else {
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
            vendorColumn.setCellValueFactory(new PropertyValueFactory<>("vendor"));
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            purchasePriceColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
            sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
            lastUpdateDateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdateDate"));

            dbTableList = databaseHandler.findProduct(search, choice);
            tableView.setItems(dbTableList);
        }
    }

    /**
     * Метод для обновления содержимого главной таблицы
     */
    void updateTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        vendorColumn.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        purchasePriceColumn.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        lastUpdateDateColumn.setCellValueFactory(new PropertyValueFactory<>("lastUpdateDate"));

        dbTableList = databaseHandler.getProduct();
        tableView.setItems(dbTableList);
    }

}