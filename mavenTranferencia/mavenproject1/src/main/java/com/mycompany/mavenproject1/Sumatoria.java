
package com.mycompany.mavenproject1;


public class Sumatoria {
    

    public static void main(String[] args) {
        int n = 5;  // Ejemplo: calcular la sumatoria de los primeros 5 términos
        int resultado = sumatoriaSerie(n);
        System.out.println("La sumatoria de los primeros " + n + " términos es: " + resultado);
    }

    public static int sumatoriaSerie(int n) {
        int sumatoria = 0;
        
        for (int i = 1; i <= n; i++) {
            sumatoria += (i * (i + 1)) * (i * (i + 1));
        }
        
        return sumatoria;
    }
}
    

