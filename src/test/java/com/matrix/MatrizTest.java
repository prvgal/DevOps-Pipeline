package com.matrix;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

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
}