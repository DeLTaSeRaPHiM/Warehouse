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
        String insert = "UPDATE " + Constants.WAREHOUSE_DB + " SET " + Constants.NAME + "=?," +
                Constants.CATEGORY_PRODUCT + "=?," + Constants.TYPE_PRODUCT + "=?," + Constants.VENDOR + "=?," +
                Constants.QUANTITY + "=?," + Constants.RETAIL_PRICE + "=?," + Constants.PURCHASE_PRICE + "=?," +
                Constants.SELL_PRICE + "=? WHERE " + Constants.ID + "=?";

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
            prSt.setInt(9, warehouse.getId());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаления выбранной строки таблицы
     * @param id
     */
    public void deleteRow(int id) {
        String delete = "DELETE FROM " + Constants.WAREHOUSE_DB + " WHERE " + Constants.ID + "=?;";

        try {
            PreparedStatement prSt = getConnection().prepareStatement(delete);
            prSt.setInt(1, id);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод отображения таблицы базы данных с фильтром категории
     * @return возвращает отсортированную базу данных
     */
    public ObservableList<Warehouse> sortByCategory(String choice) {
        String sql = "SELECT * FROM " + Constants.WAREHOUSE_DB + " WHERE " + Constants.CATEGORY_PRODUCT + "=?";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(sql);
            prSt.setString(1, (choice));

            ResultSet result = prSt.executeQuery();
            ObservableList<Warehouse> list = FXCollections.observableArrayList();
            while (result.next()) { //Получение данных из столбцов базы данных
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
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод поиска с фильтром значения выбранного столбца в базе данных
     * @param search идентификатор поиска
     * @return возвращает отсортированную базу данных
     */
    public ObservableList<Warehouse> findProduct(String search, String choice) {
        String flag;
        switch (choice) {
            case "Наименованию":
                flag = Constants.NAME;
                break;
            case "Категории":
                flag = Constants.CATEGORY_PRODUCT;
                break;
            case "Типу":
                flag = Constants.TYPE_PRODUCT;
                break;
            case "Производителю":
                flag = Constants.VENDOR;
                break;
            case "Кол-ву":
                flag = Constants.QUANTITY;
                break;
            default:
                flag = Constants.NAME;
        }

        String sql = "SELECT * FROM " + Constants.WAREHOUSE_DB + " WHERE " + flag + " LIKE (?)";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(sql);
            prSt.setString(1, search);

            ResultSet result = prSt.executeQuery();
            ObservableList<Warehouse> list = FXCollections.observableArrayList();
            while (result.next()) { //Получение данных из столбцов базы данных
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
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод проверки уникальности названия товара
     * @param name проверяемое имя поля
     * @return возвращает найденные поля с данным именем
     */
    public ResultSet checkName(String name) {
        ResultSet resSet = null;
        String sql = "SELECT * FROM " + Constants.WAREHOUSE_DB + " WHERE " + Constants.NAME + "=?";

        try {
            PreparedStatement prSt = getConnection().prepareStatement(sql);

            prSt.setString(1, name);

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }


}