import java.util.Random;
import java.util.Arrays;

public class Main {
    public static final int TAMANY = 6;
    public static void main(String[] args) {
        int a = 6;
        int b = 6;
        int[][] colonia = new int[a][b];
        int[][] coloniaRandom = generarColonia(colonia);
        mostrarArray(coloniaRandom);
        int[][] coloniaEstable = buclarGeneracions(coloniaRandom);
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

    /**
     * Funció on és buclen les colónies fins ser estables,
     * compta generacions i crida altres funcions per ajudar
     *
     * @param coloniaProcesada Colonia generada de forma aleatòria
     * @return coloniaEstable
     */
    public static int[][] buclarGeneracions(int[][] coloniaProcesada) {
        //Compta les iteracions fins trobar la generació estable
        int generacio = 1;
        //Array que guarda l'anterior generació
        int[][] coloniaAbans;
        //Bucle que s'executa fins que dos Arrays són iguals
        while (true) {
            System.out.println("Generació " + generacio);
            /*
             * RESUM: Crea un Array exactament igual que no rep cap modificació
             * .stream: Sequència d'elements que pot ser processada de manera sequèncial/paral·lela
             * .map(int[] : : clone): Transforma cada element d'un Stream. Amb int clone, és
             * fa una copia exacta del Array
             * .toArray(int[][] : : new): Crea un Array bidimensional amb les dades clonades
             *
             */
            coloniaAbans = Arrays.stream(coloniaProcesada).map(int[]::clone).toArray(int[][]::new);
            //Cridem funció
            Creixement(coloniaProcesada);
            //És comprova que els dos Arrays siguin iguals
            if (Arrays.deepEquals(coloniaProcesada, coloniaAbans)) {
                //Tanca bucle
                break;
            }
            generacio++;
        }
        return coloniaProcesada;
    }

    /**
     * Funció que rep un Array i modifica valor per valor, segons
     * les condicions de "valorarVeins"
     * @param coloniaImportada Colonia anterior que serà modificada
     * @return Array modificada
     */
    public static int[][] Creixement(int[][] coloniaImportada) {
        //Definim variables
        //Valor original
        int valorTemporal = 0;
        //Valor a modificar
        int valor = 0;
        //Array que és modificarà
        int [][] coloniaExportar = new int [TAMANY][TAMANY];
        //Doble for per modificar valors
        for (int i = 0; i < coloniaImportada.length; i++)   {
            for (int j = 0; j < coloniaImportada.length; j++) {
                //Extreu valor original
                valorTemporal = coloniaImportada[i][j];
                //Modifica i retorna valor
                valor = valorarVeins(valorTemporal);
                //Afegeix valor a matriu buida
                coloniaExportar[i][j] = valor;
            }
        }
        return coloniaExportar;
    }
    public static int valorarVeins (int valor)  {
        return valor;
    }
}