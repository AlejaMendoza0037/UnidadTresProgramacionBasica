
package com.mycompany.mavenproject1;

import java.util.Scanner;

public class Factorial {
     

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, ingresa un número para calcular su factorial: ");
        int num = scanner.nextInt();
        
        long resultado = calcularFactorial(num);
        
        System.out.println("El factorial de " + num + " es: " + resultado);
    }

    public static long calcularFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * calcularFactorial(n - 1);
    }
    
}
