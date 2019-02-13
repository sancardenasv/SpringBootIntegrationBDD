package starter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class H2Database {
    private final static Logger logger = LoggerFactory.getLogger(H2Database.class);
    private static String dbUrl;
    private static String dbDriver;
    private static String dbUser;
    private static String dbPassword;
    private static Connection connection;

    private H2Database() {
        dbUrl = "jdbc:h2:tcp://localhost/~/eva-test-db.h2db;DB_CLOSE_DELAY=-1;MODE=Oracle;";
        dbDriver = "org.h2.Driver";
        dbUser = "sa";
        dbPassword = "";
        connection = connect();
    }

    private static Connection connect() {
        try {
            Class.forName(dbDriver);
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            logger.error("Data Base Connection failed: ", e);
        }
        return null;
    }

    private static final class H2DatabaseManagerHolder {
        private final static H2Database instance = new H2Database();
    }

    public static H2Database getInstance() {
        return H2DatabaseManagerHolder.instance;
    }

    public static Connection getConnection() {
        return connection;
    }

}
