import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int a = 6;
        int b = 6;
        int[][] colonia = new int[a][b];
        int[][] coloniaRandom = generarColonia(colonia);
        mostrarArray(coloniaRandom);
    }

    /**
     * Funció que genera una colonia aleatoria (1,0)
     * utilitzant bucles for
     *
     * @param coloniaRandom Array multidimensional buida
     * @return Array ple
     */
    public static int[][] generarColonia(int[][] coloniaRandom) {
        //Doble for per assignar un valor a cada casella de l'Array
        for (int i = 0; i < coloniaRandom.length; i++) {
            for (int j = 0; j < coloniaRandom.length; j++) {
                //Crida la funcio randomBacteri
                int bacteri = randomBacteri();
                //Omple la casella
                coloniaRandom[i][j] = bacteri;
            }
        }
        return coloniaRandom;
    }

    /**
     * Genera un 1 o 0 de forma aleatoria
     *
     * @return valor generat aleatoriament
     */
    public static int randomBacteri() {
        Random random = new Random();
        return random.nextInt(2);
    }
    /**
     * Funció que mostra el Array
     *
     * @param coloniaMostrar Array que és mostrarà
     */
    public static void mostrarArray(int[][] coloniaMostrar) {
        //Doble for per mostrar el Array
        for (int[] i : coloniaMostrar) {
            System.out.print(" [");
            for (int j : i) {
                System.out.print(i[j]);
                //Posa coma a tots els valors excepte a l'últim de cada fila
                if (j < coloniaMostrar.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        System.out.println("");
    }
}