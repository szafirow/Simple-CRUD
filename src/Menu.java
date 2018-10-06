import java.util.Scanner;

public class Menu {

	public static int show() {
		System.out.println();
		System.out.println("     ****************************************");
		System.out.println("     *                 MENU                 *");
		System.out.println("     ****************************************");
		System.out.println("     1. SELECT ALL EMPLOYEES");
		System.out.println("     2. SELECT ALL EMPLOYEES ORDER BY SALARY");
		System.out.println("     3. SELECT ONE EMPLOYEE");
		System.out.println("     4. ADD EMPLOYEE");
		System.out.println("     5. DELETE EMPLOYEE");
		System.out.println("     0. Koniec");

		Scanner in = new Scanner(System.in);
		int w = in.nextInt();

		return w;
	}
}
