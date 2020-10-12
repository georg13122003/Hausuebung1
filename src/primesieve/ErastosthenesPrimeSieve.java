/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primesieve;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Georg Mairhuber
 */
public class ErastosthenesPrimeSieve implements PrimeSieve1 {

    
    private String[] zahlen;

    public ErastosthenesPrimeSieve(int overCustom) {
        this.zahlen = new String[overCustom];
        
    }
    
    private void zahlenSummen() {
        int[] array = new int[zahlen.length];
        for (int i = 0; i < zahlen.length; i++) {
            array[i] = Integer.valueOf(zahlen[i]);
        }
        int zahlLinks;
        int zahlRechts;
        for (int i = 0; i < zahlen.length; i++) {
            for (zahlLinks = zahlRechts = Integer.valueOf(array[i]) / 2; zahlLinks > 1 && zahlRechts < array[i]; zahlLinks--, zahlRechts++) {
                if (isPrime(zahlLinks) && isPrime(zahlRechts)) {
                    zahlen[i] = zahlLinks + " + " + zahlRechts + " = " + (zahlLinks + zahlRechts);
                }
            }
        }
    }

    @Override
    public boolean isPrime(int p) {
        if (p <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printPrimes() {
        for (int i = 0; i < zahlen.length; i++) {
            System.out.println(zahlen[i]);
        }
    }

    public void primSummen() {
        geradeZahlen();
        zahlenSummen();
        printPrimes();
    }

    private void geradeZahlen() {
        List<Integer> rückgabe = new ArrayList<>();
        for (int i = 2; i < zahlen.length; i++) {
            if (i > 2 && (i % 2 == 0)) {
                rückgabe.add(i);
            }
        }
        String[] rückgabe2 = new String[rückgabe.size()];
        for (int i = 0; i < rückgabe.size(); i++) {
            rückgabe2[i] = rückgabe.get(i).toString();
        }
        zahlen = rückgabe2;
    }

    
}
