import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Здесь происходит запуск приложения, запрос данных от пользователя
    public static void main(String[] args) throws IOException {
        System.out.println("Введите данные в формате: \"X действие Y\"");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        // отправка данных на проверку в Verify. Если что-то не так, выбрасывается исключение.
        // показывается сообщение ошибки и программа завершается
        try {
            Verify.makeVerify(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        // если все верно, производим рассчет.
        Calculator.calculate();
    }
}

