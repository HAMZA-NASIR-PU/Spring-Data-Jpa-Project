
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.sql.*;

public class SQL {
    private final String dbName;
    private final String tableName;
    private HikariDataSource dataSource;

    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY AUTO_INCREMENT, timestamp BIGINT NOT NULL, username TEXT NOT NULL, port INTEGER NOT NULL)";
    private static final String CREATE_ACCOUNT_SQL = "INSERT INTO %s (timestamp, username, port) VALUES (UNIX_TIMESTAMP(), ?, ?) ON DUPLICATE KEY UPDATE username = VALUES(username), port = VALUES(port)";

    public SQL(File dataFolder, String dbName, String tableName) throws SQLException {
        this.dbName = dbName;
        this.tableName = tableName;

        try {
            this.createDB();
            this.setupDataSource();
            this.setup();
        } catch (SQLException ex) {
            throw new SQLException("Failed to initialize SQL database and table", ex);
        }
    }

    private void setupDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(String.format("jdbc:mysql://%s/%s", Settings.IMP.MYSQL_HOST, Settings.IMP.MYSQL_DB));
        config.setUsername(Settings.IMP.MYSQL_USER);
        config.setPassword(Settings.IMP.MYSQL_PASSWORD);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheResultSetMetadata", "true");
        config.addDataSourceProperty("cacheServerConfiguration", "true");
        config.addDataSourceProperty("elideSetAutoCommits", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");

        this.dataSource = new HikariDataSource(config);
    }

    protected void setup() throws SQLException {
        try (Connection con = this.dataSource.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(String.format(CREATE_TABLE_SQL, tableName));
            DatabaseMetaData md = con.getMetaData();

            // Example for adding a new column if it doesn't exist (uncomment if needed)
            // if (isColumnMissing(md, "birthday")) {
            // st.executeUpdate("ALTER TABLE " + tableName + " ADD COLUMN birthday
            // INTEGER;");
            // }
        }
    }

    protected void createDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Failed to load MySQL JDBC class", e);
        }

        try (Connection localcon = DriverManager.getConnection(
                String.format(
                        "jdbc:mysql://%s/?user=%s&password=%s&validationQuery=\"SELECT 1\"&testOnBorrow=true&autoReconnect=true&character_set_server=utf8mb4",
                        Settings.IMP.MYSQL_HOST, Settings.IMP.MYSQL_USER, Settings.IMP.MYSQL_PASSWORD));

                Statement statement = localcon.createStatement()) {

            String sql = "CREATE DATABASE " + this.dbName;
            statement.executeUpdate(sql);
            System.out.println("Database created!");

        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007) {
                // Database already exists error
                System.out.println(sqlException.getMessage());
            } else {
                sqlException.printStackTrace();
            }
        }
    }

    public void createAccount(String username, int port) throws SQLException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(String.format(CREATE_ACCOUNT_SQL, tableName))) {

            ps.setString(1, username);
            ps.setInt(2, port);
            ps.executeUpdate();
        }
    }

    public boolean isAccountExists(long userid) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setLong(1, userid);
            ResultSet result = ps.executeQuery();
            return result.next();
        }
    }

    public int getId(long userid) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setLong(1, userid);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return result.getInt("id");
            }
            return -1;
        }
    }

    // Example method to check if a column is missing (not used but helpful in case
    // of schema updates)
    private boolean isColumnMissing(DatabaseMetaData md, String columnName) throws SQLException {
        try (ResultSet rs = md.getColumns(null, null, tableName, columnName)) {
            return !rs.next();
        }
    }
}
