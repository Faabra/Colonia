import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int a = 6;
        int b = 6;
        int[][] colonia = new int[a][b];
        int[][] coloniaRandom = generarColonia(colonia);
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
}