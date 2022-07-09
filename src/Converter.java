import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Converter {
    private static final HashMap<Integer, Character> tableview = new HashMap<>() {
        {
            put(1, 'I');
            put(5, 'V');
            put(10, 'X');
        }
    };

    public boolean roman(String string) {
        return string.matches("[IVX]*");
    }

    public String convertToRoman(int number) throws Exception {
        if (number > 39) {
            throw new Exception("Калькулятор принимает числа от 1 до 10 включительно");
        }
        String output = "";
        int i = number % 10;
        int j = number % 100 - i;

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
        if (num / 10 == 0) {
            multipl = 1;
        } else {
            multipl = 10;
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
        if (string.length == 2) {
            int num1 = getKey(string[0]);
            int num2 = getKey(string[1]);
            if (num1 > num2) {
                output = output + num1 + num2;
            } 
			else if (num1 < num2) {
				output = output + num2 - num1;
			}
			else {
                output += num1;
            }
        }
		else {
			throw new Exception("Калькулятор принимает числа от 1 до 10 включительно");
		}
        return (output);
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
