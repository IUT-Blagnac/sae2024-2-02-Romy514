package iut.sae.algo;

import java.time.Instant;
import java.util.Scanner;

public class RLEConsole {

    public static void main(String[] args) {

        String in = "";

        if (args.length > 0) {
            in = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Chaine à transformer : ");
            in = scanner.next();

            scanner.close();
        }
        System.out.println("Entrée : " + in);
        long startTime = System.currentTimeMillis();
        System.out.println("Sortie : " + Algo.RLE(in));
        Instant end = Instant.now();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Temps d'exécution en millisecondes : " + executionTime);
    }
}
