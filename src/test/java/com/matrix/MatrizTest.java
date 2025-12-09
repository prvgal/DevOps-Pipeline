package src.test.java.com.matrix;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

import src.main.java.com.matrix.Matriz;

public class MatrizTest {

    private Matriz matrizApp;

    @Before
    public void setUp() {
        matrizApp = new Matriz();
    }

    @Test
    public void testSumaMatrices3x3() {
        // Arrange
        int[][] a = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] b = { {9, 8, 7}, {6, 5, 4}, {3, 2, 1} };
        int[][] esperado = { {10, 10, 10}, {10, 10, 10}, {10, 10, 10} };

        // Act
        int[][] resultado = matrizApp.sumar(a, b);

        // Assert
        assertArrayEquals("La suma no es correcta", esperado, resultado);
    }

    @Test
    public void testRestaMatrices3x3() {
        // Arrange
        int[][] a = { {10, 20, 30}, {40, 50, 60}, {70, 80, 90} };
        int[][] b = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] esperado = { {9, 18, 27}, {36, 45, 54}, {63, 72, 81} };

        // Act
        int[][] resultado = matrizApp.restar(a, b);

        // Assert
        assertArrayEquals("La resta no es correcta", esperado, resultado);
    }

    // --- NUEVO TESTS ITERACIÓN 2 ---

    @Test
    public void testMultiplicacionMatrices3x3() {
        // Arrange: Usamos la Identidad para facilitar la comprobación (A * I = A)
        int[][] a = { 
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9} 
        };
        int[][] identidad = { 
            {1, 0, 0}, 
            {0, 1, 0}, 
            {0, 0, 1} 
        };

        // Act
        int[][] resultado = matrizApp.multiplicar(a, identidad);

        // Assert: El resultado debe ser idéntico a la matriz 'a'
        assertArrayEquals("La multiplicación por identidad falló", a, resultado);
    }

    @Test
    public void testProductoEscalar3x3() {
        // Arrange
        int[][] a = { 
            {2, 0, -2}, 
            {4, 10, 100}, 
            {1, -1, 0} 
        };
        int escalar = 2;
        
        // Esperamos que todo se duplique
        int[][] esperado = { 
            {4, 0, -4}, 
            {8, 20, 200}, 
            {2, -2, 0} 
        };

        // Act
        int[][] resultado = matrizApp.productoEscalar(a, escalar);

        // Assert
        assertArrayEquals("El producto escalar no es correcto", esperado, resultado);
    }
}
