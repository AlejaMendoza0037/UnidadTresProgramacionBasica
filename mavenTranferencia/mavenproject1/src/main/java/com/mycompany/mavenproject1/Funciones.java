
package com.mycompany.mavenproject1;


    


public class Funciones {
     public static void main(String[] args) {
      //  System.out.println("Hello World!");
    calcularAreaCirculo();
    calcularAreaRectangulo(10.0, 5.0);
    int numeroAleatorio = generarNumeroAleatorio();
        System.out.println("Número aleatorio generado: " + numeroAleatorio);
        
        int resultado = sumar(5, 7);
        System.out.println("La suma de 5 y 7 es: " + resultado);
    
    
}
public static void calcularAreaCirculo(){
double radio=5.0;
double area =Math.PI *radio*radio;

         
        System.out.println("El área del círculo con radio " + radio + " es: " + area);
    }


public static void calcularAreaRectangulo(double largo, double ancho) {
        double area = largo * ancho;
        System.out.println("El área del rectángulo con largo " + largo + " y ancho " + ancho + " es: " + area);
    }


public static int generarNumeroAleatorio() {
        return (int)(Math.random() * 100) + 1;
    }


public static int sumar(int a, int b) {
        return a + b;
    }

}







