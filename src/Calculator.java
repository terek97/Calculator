import acttions.*;

public class Calculator {

    public static void calculate() {


        //получаем тот самый массив с введенными элементами
        String[] elements = Verify.getElements();

        //разделяем на переменные для удобства
        int first;
        String action = elements[1];
        int third;

        //если числа римские, отправляем на перевод в арабские
        if (Verify.getIsRoman()) {
            first = Converter.ConvertToArabic(elements[0]);
            third = Converter.ConvertToArabic(elements[2]);
        } else {
            first = Integer.parseInt(elements[0]);
            third = Integer.parseInt(elements[2]);
        }

        // создаем объект и в зависимости от введенного действия присваем ему значение.
        Calculating calc;
        switch (action) {
            case "+" -> calc = new Addition();
            case "-" -> calc = new Subtraction();
            case "*" -> calc = new Multiplication();
            case "/" -> calc = new Division();
            default -> throw new IllegalStateException("Unexpected value: " + action);
        }
        // получаем результат и если изначально были введены римские цифры, конвертируем его обратно
        int result = calc.makeAction(first, third);
        if (Verify.getIsRoman()) {
            System.out.println(Converter.ConvertToRoman(result));
        } else {
            System.out.println(result);
        }
    }
}


