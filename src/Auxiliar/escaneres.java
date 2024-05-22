package Auxiliar;

import java.util.Scanner;
public class escaneres {

    private static Scanner scanner = new Scanner(System.in);

    // Método estático para leer una línea

    public static String nextLine() {

        return scanner.nextLine();

    }

    // Método estático para leer un entero

    public static int nextInt() {

        int value = scanner.nextInt();

        scanner.nextLine(); // Limpiar el buffer después de leer un entero

        return value;

    }

    // Método estático para leer un double

    public static double nextDouble() {

        double value = scanner.nextDouble();

        scanner.nextLine(); // Limpiar el buffer después de leer un double

        return value;

    }

}
