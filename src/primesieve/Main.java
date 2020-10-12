/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primesieve;

import java.util.Scanner;

/**
 *
 * @author Georg Mairhuber
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1...PrimZahlen ausgeben!");
        System.out.println("2...Gerade Zahlen mit Primzahlen ausgeben!");
        try {
            int input = Integer.valueOf(sc.nextLine());
            System.out.print("Grenze:");
            int grenze = Integer.valueOf(sc.nextLine());
            ErastosthenesPrimeSieve eps = new ErastosthenesPrimeSieve(grenze);
            switch (input) {
                case 1:
                    boolean[] isPrime = new boolean[grenze];
                    isPrime[0] = false;
                    for (int j = 1; j < grenze; j++) {
                        isPrime[j] = true;
                    }
                    for (int i = 2; i < grenze; i++) {
                        if (isPrime[i - 1]) {
                            System.out.println(i);
                            for (int m = 2 * i; m < grenze; m += i) {
                                isPrime[m - 1] = false;
                            }
                        }
                    }
                    break;

                case 2:
                    if (grenze > 2 && (grenze % 2 == 0)) {
                        eps.primSummen();
                    } else {
                        throw new Exception("Grenze war zu klein oder ungerade!");
                    }
                    break;

                default:
                    System.out.println("Feler bei der eingabe");
                    break;
            }
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}
