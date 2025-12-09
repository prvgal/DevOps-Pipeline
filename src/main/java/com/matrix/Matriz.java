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

    // --- NUEVO EN ITERACIÓN 2 ---

    // Operación 3: Multiplicación de dos matrices 3x3
    // Algoritmo: Fila de A * Columna de B
    public int[][] multiplicar(int[][] a, int[][] b) {
        int[][] resultado = new int[3][3];
        for (int i = 0; i < 3; i++) { // Filas de A
            for (int j = 0; j < 3; j++) { // Columnas de B
                for (int k = 0; k < 3; k++) { // Sumatoria del producto
                    resultado[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return resultado;
    }

    // Operación 4: Producto Escalar (Multiplicar matriz por un número)
    public int[][] productoEscalar(int[][] a, int escalar) {
        int[][] resultado = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultado[i][j] = a[i][j] * escalar;
            }
        }
        return resultado;
    }


}
