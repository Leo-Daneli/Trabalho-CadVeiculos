import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
    private static InputStreamReader teclado = new InputStreamReader(System.in);
    private static BufferedReader buffer = new BufferedReader(teclado);

    public static String readString(String mensagem) {
        try {
            System.out.print(mensagem);
            return buffer.readLine();
        } catch (Exception e) {
            return "";
        }
    }

    public static int readInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(buffer.readLine());
            } catch (Exception e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }
}