package warehouse.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import warehouse.config.Warehouse;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection connection;

    /**
     * Метод подключения и инициализации базы данных
     */
    public Connection getConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return connection;
    }

    /**
     * Метод получения значений из базы данных
     * @return список значений из базы данных
     */
    public ObservableList<Warehouse> getProduct() {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM "  + Constants.WAREHOUSE_DB);
            ResultSet result = statement.executeQuery();
            ObservableList<Warehouse> list = FXCollections.observableArrayList();
            while (result.next()) {
                Warehouse warehouse = new Warehouse();

                warehouse.setId(result.getInt(Constants.ID));
                warehouse.setName(result.getString(Constants.NAME));
                warehouse.setProductCategory(result.getString(Constants.CATEGORY_PRODUCT));
                warehouse.setProductType(result.getString(Constants.TYPE_PRODUCT));
                warehouse.setVendor(result.getString(Constants.VENDOR));
                warehouse.setQuantity(result.getInt(Constants.QUANTITY));
                warehouse.setRetailPrice(result.getInt(Constants.RETAIL_PRICE));
                warehouse.setPurchasePrice(result.getInt(Constants.PURCHASE_PRICE));
                warehouse.setSellPrice(result.getInt(Constants.SELL_PRICE));

                list.add(warehouse);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод добавления продукта в базу данных
     * @param warehouse объект, содержащий данные для ввода в базу данных
     */
    public void addProduct(Warehouse warehouse) {
        String insert = "INSERT INTO " + Constants.WAREHOUSE_DB + "(" + Constants.NAME + ", "
                + Constants.CATEGORY_PRODUCT + ", " + Constants.TYPE_PRODUCT + ", " + Constants.VENDOR + ", "
                + Constants.QUANTITY + ", " + Constants.RETAIL_PRICE + ", " + Constants.PURCHASE_PRICE + ", "
                + Constants.SELL_PRICE + ") " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);

            prSt.setString(1, warehouse.getName());
            prSt.setString(2, warehouse.getProductCategory());
            prSt.setString(3, warehouse.getProductType());
            prSt.setString(4, warehouse.getVendor());
            prSt.setInt(5, warehouse.getQuantity());
            prSt.setDouble(6, warehouse.getRetailPrice());
            prSt.setDouble(7, warehouse.getPurchasePrice());
            prSt.setDouble(8, warehouse.getSellPrice());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обновления поля базы данных
     * @param warehouse объект с содержимым базы данных для изменения
     */
    public void updateProduct(Warehouse warehouse) {

    }

    public void deleteRows(String id) {
        try {
            Connection connection = getConnection();
            String sql = "DELETE FROM"  + Constants.WAREHOUSE_DB + "WHERE " + Constants.ID + " = " + id + ";";

            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Метод проверки уникальности названия товара
     * @param warehouse
     * @return
     */
    public ResultSet checkName(Warehouse warehouse) {
        ResultSet resSet = null;
        String sql = "SELECT * FROM " + Constants.WAREHOUSE_DB + " WHERE " + Constants.NAME + "=?";

        try {
            PreparedStatement prSt = getConnection().prepareStatement(sql);

            prSt.setString(1, warehouse.getName());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }


}