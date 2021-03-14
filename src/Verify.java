public class Verify {

    private static String[] elements; //здесь хранятся данные
    private static Boolean isRoman = false; //римские или арабские


    //геттер для получения массива с данными
    public static String[] getElements() {
        return elements;
    }

    //геттер узнать какие символы (арабские или римские)
    public static Boolean getIsRoman() {
        return isRoman;
    }

    // главный метод, запускает все проверки. после первой ошибки выбрасывает исключение и дальше проверять не идет
    public static void makeVerify(String input) throws Exception {
        makeList(input);
        verifyCount(elements);
        verifyForIntegers(elements);
        if (!isRoman) {
            verifyForPositive(elements);
            verifyForSize(elements);
        }
        verifyAction(elements);
    }

    // создаем массив из введенных данных
    private static void makeList(String input) {
        elements = input.split(" ");
    }

    // проверка на количество элементов
    private static void verifyCount(String[] elements) throws Exception {
        if (elements.length != 3) {
            throw new Exception("Вы ввели неверное число элементов (проверьте свой ввод на наличие пробелов.)" +
                    "Примеры правильного ввода: 1 + 2 или VI / III.");
        }
    }

    //проверяем на целочисленность. если к инту не приводится, проверяем может быть там римские цифры.
    private static void verifyForIntegers(String[] elements) throws Exception {
        try {
            Integer.parseInt(elements[0]);
            Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            verifyForRomans(elements);
            if (!(isRoman)) {
                throw new Exception("Данные введены в неверном формате. " +
                        "Калькулятор умеет работать только с целыми числами.");
            }
        }
    }

    // проверка на положительные числа. Запускается только для арабских цифр
    private static void verifyForPositive(String[] elements) throws Exception {
        if (!(Integer.parseInt(elements[0]) > 0 & Integer.parseInt(elements[2]) > 0)) {
            throw new Exception("Данные введены в неверном формате. " +
                    "Калькулятор умеет работать только с положительными числами.");
        }
    }

    //проверка на размер (не больше 10). Запускается только для арабских цифр
    private static void verifyForSize(String[] elements) throws Exception {
        if (!(Integer.parseInt(elements[0]) < 11 & Integer.parseInt(elements[2]) < 11)) {
            throw new Exception("Данные введены в неверном формате. " +
                    "Калькулятор умеет работать только с числами от 1 до 10 включительно.");
        }
    }

    //проверка математического действия (только +-*/)
    private static void verifyAction(String[] elements) throws Exception {
        if (!(elements[1].equals("+") | elements[1].equals("-") | elements[1].equals("*") | elements[1].equals("/"))) {
            throw new Exception("Данные введены в неверном формате. " +
                    "Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления.");
        }
    }

    //проверка на римские цифры
    private static void verifyForRomans(String[] elements) throws Exception {
        if (Converter.getRoman().contains(elements[0]) & Converter.getRoman().contains(elements[2])) {
            isRoman = true;
        }
        // выбрасывает исключение если один из элементов входит в массив римских чисел, а другой нет
        else if (Converter.getRoman().contains(elements[0]) | Converter.getRoman().contains(elements[2])) {
            throw new Exception("Данные введены в неверном формате. " +
                    "Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, " +
                    "при вводе пользователем строки вроде 3 + II возникнет ошибка." +
                    "Так же калькулятор умеет работать только с числами от I до X включительно.");
        }
    }
}

