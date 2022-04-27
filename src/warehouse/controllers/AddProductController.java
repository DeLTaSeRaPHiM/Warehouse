package warehouse.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import warehouse.config.Warehouse;
import warehouse.database.DatabaseHandler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddProductController {

    @FXML
    private TextField categoryField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField vendorField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField sellPriceField;

    @FXML
    private TextField purchasePriceField;

    @FXML
    private TextField quantityField;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    DatabaseHandler databaseHandler = new DatabaseHandler();
    int counter = 0;


    /**
     * Метод добавления значений полей в базу данных
     */
    @FXML
    public void add(ActionEvent event) {
        LocalDate localDate = LocalDate.now();
        String temp = localDate.toString();

        Warehouse warehouse = new Warehouse();
        warehouse.setName(nameField.getText());
        warehouse.setProductCategory(categoryField.getText());
        warehouse.setProductType(typeField.getText());
        warehouse.setVendor(vendorField.getText());
        warehouse.setQuantity(Integer.parseInt(quantityField.getText()));
        warehouse.setPurchasePrice(Double.parseDouble(purchasePriceField.getText()));
        warehouse.setSellPrice(Double.parseDouble(sellPriceField.getText()));
        warehouse.setLastUpdateDate(temp);

        ResultSet resultSet = databaseHandler.checkName(warehouse.getName());
        try {
            while (resultSet.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (counter < 1) {
            databaseHandler.addProduct(warehouse);
        }

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Метод возврата/закрытия окна добавления
     */
    @FXML
    public void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}