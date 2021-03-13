import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Здесь происходит запуск приложения, запрос данных от пользователя

    public static void main(String[] args) throws IOException {
        System.out.println("Введите данные в формате: \"X действие Y\"");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        // отправка данных на проверку в Verify.
        if (!(Verify.makeVerify(input))) {
            System.out.println("Данные введены в неверном формате");
        } else {
            // если все верно, производим рассчет.
            Calculation.calculate();
        }
    }
}
