import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {

	Connection conn;
	Statement stmt;
	ResultSet result;
	Scanner input;

	public void showAll() throws SQLException {
		conn = DBConnect.getConnection();
		stmt = conn.createStatement();
		result = stmt.executeQuery("select * from EMPLOYEES");
		while (result.next())
			System.out.println(result.getInt(1) + "  " + result.getString(2) + "  " + result.getString(3));
		conn.close();
	}

	public void showAllorderSalary() throws SQLException {
		conn = DBConnect.getConnection();
		stmt = conn.createStatement();
		result = stmt.executeQuery("select * from EMPLOYEES ORDER BY SALARY ASC");
		while (result.next()) {
			String first_name = result.getString("FIRST_NAME");
			String last_name = result.getString("LAST_NAME");
			float salary = result.getFloat("SALARY");
			System.out.println(first_name + " " + last_name + " zarabia: " + salary);
		}
		conn.close();
	}

	public void showOne() throws SQLException {
		System.out.println("Podaj numer osoby jaka chcesz wyswietlic:");
		input = new Scanner(System.in);
		int id = input.nextInt();

		conn = DBConnect.getConnection();
		stmt = conn.createStatement();
		result = stmt.executeQuery("select * from EMPLOYEES WHERE EMPLOYEE_ID =" + id);

		while (result.next()) {
			String first_name = result.getString("FIRST_NAME");
			String last_name = result.getString("LAST_NAME");
			System.out.println(first_name + " " + last_name);
		}
		conn.close();
	}

	public void insert() throws SQLException {
		System.out.println("Podaj numer pracownika:");
		input = new Scanner(System.in);
		int num = input.nextInt();

		System.out.println("Podaj imie:");
		input = new Scanner(System.in);
		String name = input.nextLine();

		System.out.println("Podaj nazwisko:");
		input = new Scanner(System.in);
		String surname = input.nextLine();

		System.out.println("Podaj emial:");
		input = new Scanner(System.in);
		String email = input.nextLine();

		System.out.println("Podaj wynagrodzenie:");
		input = new Scanner(System.in);
		String salary = input.nextLine();

		conn = DBConnect.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate(
				"Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) "
						+ "values (" + num + ",'" + name + "','" + surname + "','" + email
						+ "',to_date('18/10/06','RR/MM/DD'),'SA_REP','" + salary + "','0,35','146','80')");

		conn.close();
		System.out.println("Dodano do bazy!");
	}

	public void delete() throws SQLException {
		System.out.println("Podaj numer osoby jaka chcesz usunac:");
		input = new Scanner(System.in);
		int id = input.nextInt();

		conn = DBConnect.getConnection();
		stmt = conn.createStatement();
		stmt.execute("delete from employees WHERE EMPLOYEE_ID =" + id);
		stmt.toString();
		conn.close();
		System.out.println("Usuniêto z bazy!");
	}

}
