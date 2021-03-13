import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Converter {
    // TreeMap выбран для использования метода floorkey
    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    //массив римских цифр от 1 до 10
    private static final List<String> roman = new ArrayList<>();

    static {
        //добавляем нулевой элемент для удобства обращения
        roman.add(null);
        roman.add("I");
        roman.add("II");
        roman.add("III");
        roman.add("IV");
        roman.add("V");
        roman.add("VI");
        roman.add("VII");
        roman.add("VIII");
        roman.add("IX");
        roman.add("X");
    }

    //геттер, возвращает массив выше. нужен для проверки на римские цифры
    public static List<String> getRoman() {
        return roman;
    }

    // перевод арабских цифр в римских
    public static String ConvertToRoman(int number) {
        // Метод floorKey () используется для возврата наибольшего ключа, меньшего или равного данному ключу из параметра.
        int l = map.floorKey(number);
        if (number == l) {
            // если число равно числу в тримапе, возвращаем его
            return map.get(number);
        }
        //рекурсия
        return map.get(l) + ConvertToRoman(number - l);
    }

    //перевод римских цифр в арабские
    public static int ConvertToArabic(String number) {
        return roman.indexOf(number);
    }
}


