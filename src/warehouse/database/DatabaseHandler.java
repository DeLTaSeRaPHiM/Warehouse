package warehouse.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    Connection dbConnection;

    public Connection getDbConnection()
            throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" +
                "localhost:3306/warehouse" +  //IP, port, DB name
                "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, "root", "12345");
        return dbConnection;
    }
}
