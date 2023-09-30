
package com.mycompany.mavenproject1;

import java.util.Scanner;

public class Empleado {

    public static void main(String[] args) {
        imprimirDatosEmpleado();
    }

    public static void imprimirDatosEmpleado() {
        Scanner scanner = new Scanner(System.in);

        // Leer los datos desde el teclado
        System.out.print("Ingresa el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el apellido del empleado: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingresa la edad del empleado: ");
        int edad = scanner.nextInt();

        // Imprimir los datos
        System.out.println("\nDatos del Empleado:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
    }
}