import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class main {
	public static void main() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(calc(br.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void intro() {
		System.out.println("Welcome! This is a simple calculator that accepts Roman or Arabic numbers (2 at any given time at most).\n This calculator works with integers from 1 to 10 (or I to X).\n");
	}
    public static String calc(String input) throws Exception {
		intro();
        int     num1;
        int     num2;
        String  op;

        try (Scanner scanner = new Scanner(System.in)) {
			num1 = scanner.nextInt();
			op = scanner.next();
			num2 = scanner.nextInt();
		}
        switch (op) {
            case "+" -> System.out.println(num1 + num2);
            case "-" -> System.out.println(num1 - num2);
            case "*" -> System.out.println(num1 * num2);
            case "/" -> System.out.println(num1 / num2);
        }
        return op;
    }
}
