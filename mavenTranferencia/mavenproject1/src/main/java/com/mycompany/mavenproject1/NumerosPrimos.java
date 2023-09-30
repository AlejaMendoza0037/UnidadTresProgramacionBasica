
package com.mycompany.mavenproject1;

public class NumerosPrimos {

    public static void main(String[] args) {
        imprimirPrimosEnRango(10, 50);  // Ejemplo: imprimirá los primos entre 10 y 50
    }

    public static void imprimirPrimosEnRango(int x, int y) {
        if (x > y) {
            System.out.println("El valor de x debe ser inferior a y.");
            return;
        }

        System.out.println("Números primos entre " + x + " y " + y + ":");
        for (int i = x; i <= y; i++) {
            if (esPrimo(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}