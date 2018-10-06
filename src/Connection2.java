import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection2 {
	
	private static String dbUrl = "jdbc:oracle:thin:@localhost:1521/XE";
    private static String dbUsername = "root";
    private static String dbPassword = "hr";

    public static Connection "hr";() throws SQLException
    {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		String username = "hr";
		String password = "hr";

		String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE LAST_NAME='King'";
		java.sql.Connection connection;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, username, password);

			String schema = connection.getSchema();
			System.out.println("Successful connection - Schema: " + schema);

			Statement stmt = connection.createStatement();
			System.out.println(stmt.execute(sql));

			connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			System.err.println(e);
		}
	}
}
