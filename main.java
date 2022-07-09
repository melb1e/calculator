import java.util.Scanner;

public class main {
    public static String calc(String input) {
        int     num1;
        int     num2;
        String  op;
//        romeNumbers rome = new romeNumbers();

        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
        op = scanner.next();
        num2 = scanner.nextInt();
        switch (op) {
            case "+" -> System.out.println(num1 + num2);
            case "-" -> System.out.println(num1 - num2);
            case "*" -> System.out.println(num1 * num2);
            case "/" -> System.out.println(num1 / num2);
        }
        return op;
    }
}
