package menu;
import java.util.Scanner;

public class Consola {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero() {
        int entero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        return entero;
    }

    public static String leerCadena() {
        return scanner.nextLine();
    }
}
