public class Calculation {

    public static void calculate() {
        //получаем тот самый массив с введенными элементами
        String[] elements = Verify.getElements();

        //разделяем на переменные для удобства
        int first;
        String action = elements[1];
        int third ;

        //если числа римские, отправляем на перевод в арабские
        if (Verify.getIsRoman()) {
            first = Converter.ConvertToArabic(elements[0]);
            third = Converter.ConvertToArabic(elements[2]);
        }
        else {
            first = Integer.parseInt(elements[0]);
            third = Integer.parseInt(elements[2]);
        }

        //запуск рассчетов в зависимости от введенного действия.
        switch (action) {
            case "+" -> addition(first, third);
            case "-" -> subtraction(first, third);
            case "*" -> Multiplication(first, third);
            case "/" -> division(first, third);
        }
    }


    private static void addition(int a, int b) {
        //если изначально были введены римские цифры, конвертируем полученный результат обратно
        if (Verify.getIsRoman()) {
            System.out.println(Converter.ConvertToRoman(a + b));
        }
        else {
            System.out.println(a + b);
        }
    }

    private static void subtraction(int a, int b) {
        //если изначально были введены римские цифры, конвертируем полученный результат обратно
        if (Verify.getIsRoman()) {
            System.out.println(Converter.ConvertToRoman(a - b));
        }
        else {
            System.out.println(a - b);
        }
    }

    private static void Multiplication(int a, int b) {
        //если изначально были введены римские цифры, конвертируем полученный результат обратно
        if (Verify.getIsRoman()) {
            System.out.println(Converter.ConvertToRoman(a * b));
        }
        else {
            System.out.println(a * b);
        }
    }

    private static void division(int a, int b) {
        //если изначально были введены римские цифры, конвертируем полученный результат обратно
        if (Verify.getIsRoman()) {
            System.out.println(Converter.ConvertToRoman(a / b));
        }
        else {
            System.out.println(a / b);
        }
    }
}
