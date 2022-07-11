import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Converter {
	private static final HashMap<Integer, Character> tableview = new HashMap<>() {
		{
			put(1, 'I');
			put(5, 'V');
			put(10, 'X');
			put(50, 'L');
			put(100, 'C');
		}
	};

	public boolean roman(String string) {
		return string.matches("[IVXLC]+");
	}

	public String convertToRoman(int number) throws Exception {
		if (number > 100) {
			throw new Exception("Калькулятор принимает числа от 1 до 10 включительно");
		}
		String output = "";
		int i = number % 10;
		int j = number % 100 - i;
		int k = number % 1000 - j - i;

		output += romanUtils(k);
		output += romanUtils(j);
		output += romanUtils(i);
		return (output);
	}

	private String romanUtils(int num) {
		StringBuilder output = new StringBuilder();

		if (num == 0) {
			return output.toString();
		}
		int multipl;
		if (num / 100 == 0) {
			if (num / 10 == 0) {
				multipl = 1;
			} else {
				multipl = 10;
			}
		} else {
			multipl = 100;
		}
		if (num < 9 * multipl) {
			if (num < 5 * multipl) {
				if (num != 4 * multipl) {
					for (int i = 0; i < num / multipl; i++) {
						output.append(tableview.get(multipl));
					}
				} else {
					output.append(tableview.get(multipl));
					output.append(tableview.get(multipl * 5));
				}
			} else {
				output.append(tableview.get(multipl * 5));
				for (int i = 0; i < (num - 5 * multipl) / multipl; i++) {
					output.append(tableview.get(multipl));
				}
			}
		} else {
			output.append(tableview.get(multipl));
			output.append(tableview.get(multipl * 10));
		}
		return (output.toString());
	}
	public Integer convertToArabic(String toConvert) throws Exception {
		int output = 0;

		char[] string = toConvert.toCharArray();
		if (string.length == 3) {
			int num1 = getKey(string[0]);
			int num2 = getKey(string[1]);
			int num3 = getKey(string[2]);
			if (num3 > num2) {
				output = num3 - num2 - num1;
			}
			else {
				output = num1 + num2 + num3;
			}
		}
		else if (string.length == 2) {
			int num1 = getKey(string[0]);
			int num2 = getKey(string[1]);
			if (num1 > num2) {
				output = num1 + num2;
			} 
			else if (num1 < num2) {
				output = num2 - num1;
			}
			else {
				output = num1 + num2;
			}
		}
		else if (string.length == 1) {
			int num = getKey(string[0]);
			output = num;
		}
		if (output != 0) {
			return (output);
		}
		else {
			throw new Exception("Калькулятор принимает числа от 1 до 10 включительно");
		}
	}
	private Integer getKey(Character num) {
		Set<Map.Entry<Integer, Character>> set = tableview.entrySet();

		for (Map.Entry<Integer, Character> entry : set) {
			if (entry.getValue() == num) {
				return entry.getKey();
			}
		}
		return (-1);
	}
}
