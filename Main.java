import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
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
		Converter converter = new Converter();
        String output = "";

		if (input == null || input.equals("")) {
			throw new Exception("Invalid input");
		}
		String[] inputs = input.split(" ");
		if (inputs.length > 3) {
			throw new Exception("Invalid input");
		}
		if (inputs.length < 3) {
			throw new Exception("Invalid input");
		}

    }

	
}
