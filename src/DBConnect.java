import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static String dbUrl = "jdbc:oracle:thin:@localhost:1521/XE";
	private static String dbUsername = "hr";
	private static String dbPassword = "hr";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}

	public void checkSchema(Connection conn) throws SQLException {
		String schema = conn.getSchema();
		System.out.println("Successful connection - Schema: " + schema);
	}

}
