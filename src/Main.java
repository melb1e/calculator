package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(calc(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String calc(String input) throws Exception {
        Converter converter = new Converter();
        String output;

        if (input == null || input.equals("")) {
            throw new Exception("Нет входных данных");
        }
        String[] inputs = input.split(" ");
        if (inputs.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (inputs.length < 3) {
            throw new Exception("Строка не является математической операцией");
        }
		int num1 = parse(inputs[0]);
		int num2 = parse(inputs[2]);
		if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1) {
            throw new Exception("Калькулятор принимает числа от 1 до 10 включительно");
        }
		else if (converter.roman(inputs[0]) ^ converter.roman(inputs[2])) {
            throw new Exception("Нельзя использовать римские и арабские числа одновременно");
        }
		else if (converter.roman(inputs[0]) || converter.roman(inputs[2])) {
            if (inputs[1].equals("-") && (num1 < num2)) {
                throw new Exception("В римской системе нет отрицательных чисел");
            } else if (inputs[1].equals("-") && (num1 == num2)) {
				throw new Exception("В римской системе цифр отсутствует ноль");
			}
            output = converter.convertToRoman(parse(calculate(num1, inputs[1], num2)));
        }
        else {
            output = calculate(num1, inputs[1], num2);
        }
        return (output);
    }

    static String calculate(Integer num1, String op, Integer num2) throws Exception {
        String output = "";

        switch (op) {
            case "+" -> output = String.valueOf(num1 + num2);
            case "-" -> output = String.valueOf(num1 - num2);
            case "*" -> output = String.valueOf(num1 * num2);
            case "/" -> output = String.valueOf(num1 / num2);
            default -> throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        return (output);
    }

    static Integer parse(String string) throws Exception {
        Integer output = null;

        try {
            output = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            if (new Converter().roman(string)) {
                output = new Converter().convertToArabic(string);
            }
        }
        return (output);
    }
}
