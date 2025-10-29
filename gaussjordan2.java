public class GaussJordan {

    public static void main(String[] args) {
        // Matriz aumentada [A|B] del sistema de ecuaciones
        double[][] matrizAumentada = {
            {5.0, -0.1, -0.2, 7.85},
            {2.1, 7.0, -0.3, -19.3},
            {0.3, -0.2, 10.0, 71.4}
        };

        // Resuelve el sistema
        resolverGaussJordan(matrizAumentada);

        // Imprime la solución
        System.out.println("La solución del sistema es:");
        System.out.printf("x1 = %.4f%n", matrizAumentada[0][3]);
        System.out.printf("x2 = %.4f%n", matrizAumentada[1][3]);
        System.out.printf("x3 = %.4f%n", matrizAumentada[2][3]);
    }

    public static void resolverGaussJordan(double[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            // Paso 1: Normalizar la fila i para que el pivote sea 1
            // Se busca el elemento más grande (pivote) en la columna i para evitar errores de división por cero
            int maxFila = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[maxFila][i])) {
                    maxFila = k;
                }
            }
            // Intercambio de filas si es necesario
            double[] temp = matriz[i];
            matriz[i] = matriz[maxFila];
            matriz[maxFila] = temp;

            // Normalización
            double pivote = matriz[i][i];
            for (int j = i; j < n + 1; j++) {
                matriz[i][j] /= pivote;
            }

            // Paso 2: Eliminación
            // Se convierte el resto de los elementos de la columna i en 0
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = i; j < n + 1; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }
    }
}


