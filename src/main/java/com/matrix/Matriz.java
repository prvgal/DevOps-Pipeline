package src.main.java.com.matrix;
public class Matriz {
    // Operación 1: Suma de matrices 3x3
    public int[][] sumar(int[][] a, int[][] b) {
        int[][] resultado = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultado[i][j] = a[i][j] + b[i][j];
            }
        }
        return resultado;
    }

    // Operación 2: Resta de matrices 3x3
    public int[][] restar(int[][] a, int[][] b) {
        int[][] resultado = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultado[i][j] = a[i][j] - b[i][j];
            }
        }
        return resultado;
    }

    // Método auxiliar para imprimir matrices (útil para el Main)
    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }



}
