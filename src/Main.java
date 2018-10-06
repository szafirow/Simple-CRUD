import java.io.IOException;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {

		System.out.println("ecipecie1");
		Employee emp = new Employee();

		int check = Menu.show();

		while (check != 0) {
			switch (check) {
			case 1:
				emp.showAll();
				break;

			case 2:
				emp.showAllorderSalary();
				break;

			case 3:
				emp.showOne();
				break;
			case 4:
				emp.insert();
				break;
			case 5:
				emp.delete();
				break;
			}

			System.out.println("\nWciœnij Enter, aby kontynuowaæ...");
			System.in.read();

			check = Menu.show();
		}

		System.out.println("     ****************************************");
		System.out.println("\n     Koniec programu\n\n");

	}

}
