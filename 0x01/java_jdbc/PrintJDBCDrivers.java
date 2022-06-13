import java.sql.*;
public class PrintJDBCDrivers {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionSQLite connectionSQLite = new ConnectionSQLite();
        connectionSQLite.connect();
    }
}
