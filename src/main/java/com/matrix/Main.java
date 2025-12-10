package src.main.java.com.matrix;
import java.util.Scanner;

public class Main {
    // Instanciamos nuestra clase de lógica
    private static Matriz logica = new Matriz();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- PROYECTO MATRIX ---");
            System.out.println("1. Sumar Matrices");
            System.out.println("2. Restar Matrices");
            System.out.println("3. Multiplicar Matrices");     // NUEVO
            System.out.println("4. Producto Escalar (Matriz * n)"); // NUEVO
            System.out.println("5. Salir");
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
                case 3: // NUEVO
                    System.out.println("--- MULTIPLICACIÓN ---");
                    ejecutarOperacion("multiplicacion");
                    break;
                case 4: // NUEVO
                    System.out.println("--- PRODUCTO ESCALAR ---");
                    ejecutarProductoEscalar();
                    break;
                case 5:
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

    // Método específico para la Opción 4
    private static void ejecutarProductoEscalar() {
        System.out.println("Ingrese la Matriz:");
        int[][] a = leerMatriz();
        
        System.out.print("Ingrese el número escalar (multiplicador): ");
        int escalar = scanner.nextInt();

        int[][] resultado = logica.productoEscalar(a, escalar);
        
        System.out.println("Resultado del Producto Escalar:");
        logica.imprimirMatriz(resultado);
    }
    
}

