package src.main.java.com.matrix;
import java.util.Scanner;

public class Main {
    // Instanciamos nuestra clase de lógica
    private static Matriz logica = new Matriz();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- PROYECTO MATRIX (Iteración 1) ---");
            System.out.println("1. Sumar Matrices");
            System.out.println("2. Restar Matrices");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--- SUMA ---");
                    ejecutarOperacion("suma");
                    break;
                case 2:
                    System.out.println("--- RESTA ---");
                    ejecutarOperacion("resta");
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void ejecutarOperacion(String tipo) {
        System.out.println("Ingrese Matriz A:");
        int[][] a = leerMatriz();
        System.out.println("Ingrese Matriz B:");
        int[][] b = leerMatriz();

        int[][] resultado = null;

        if (tipo.equals("suma")) {
            resultado = logica.sumar(a, b);
            System.out.println("Resultado de la Suma:");
        } else if (tipo.equals("resta")) {
            resultado = logica.restar(a, b);
            System.out.println("Resultado de la Resta:");
        }

        logica.imprimirMatriz(resultado);
    }

    private static int[][] leerMatriz() {
        int[][] matriz = new int[3][3];
        System.out.println("Introduce los 9 números de la matriz 3x3 (fila por fila):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }
    
}
