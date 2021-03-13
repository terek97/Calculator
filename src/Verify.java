public class Verify {

    private static String[] elements; //здесь хранятся данные
    private static Boolean isRoman = false; //римские или арабские
    private static Boolean result = true; //финальный результат


//геттер для получения массива с данными
    public static String[] getElements() {
        return elements;
    }
//геттер узнать какие символы (арабские или римские)
    public static Boolean getIsRoman() {
        return isRoman;
    }

// главный метод, запускает все проверки. при первой ошибке дальше проверять не идет
    public static Boolean makeVerify(String input) {
        makeList(input);
        verifyCount(elements);
        if (!result) return false;
        verifyForIntegers(elements);
        if (!result) return false;
        if (!isRoman) {
            verifyForPositive(elements);
            verifyForSize(elements);
        }
        if (!result) return false;
        verifyAction(elements);

        return result;
    }

// создаем массив из введенных данных
    private static void makeList(String input) {
        elements = input.split(" ");
    }

// проверка на количество элементов
    private static void verifyCount (String[] elements) {
        if (elements.length != 3) {
            result = false;
        }
    }

//проверяем на целочисленность. если к инту не приводится, проверяем может быть там римские цифры.
    private static void verifyForIntegers (String[] elements) {
        try {
            Integer.parseInt(elements[0]);
            Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            verifyForRomans(elements);
            if (!(isRoman)) {
                result = false;
            }
        }
    }

// проверка на положительные числа. Запускается только для арабских цифр
    private static void verifyForPositive (String[] elements) {
        if (!(Integer.parseInt(elements[0]) > 0 & Integer.parseInt(elements[2]) > 0)) {
            result = false;
        }
    }

//проверка на размер (не больше 10). Запускается только для арабских цифр
    private static void verifyForSize (String[] elements) {
        if (!(Integer.parseInt(elements[0]) < 11 & Integer.parseInt(elements[2]) < 11)) {
            result = false;
        }
    }

//проверка математического действия (только +-*/)
    private static void verifyAction(String[] elements) {
        if (!(elements[1].equals("+") | elements[1].equals("-") | elements[1].equals("*") | elements[1].equals("/"))) {
            result = false;
        }
    }

//проверка на римские цифры
    private static void verifyForRomans (String[] elements) {
        if (Converter.getRoman().contains(elements[0]) & Converter.getRoman().contains(elements[2])) {
            isRoman = true;
        }
    }
}

