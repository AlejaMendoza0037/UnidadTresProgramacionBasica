
package com.mycompany.mavenproject1;

 import java.util.Scanner;

public class Nomina {
    
   


// declaramos cariables staticas

    private static final double SMMLV = 877803; 
    private static final double PORCENTAJE_COMISION = 0.05;
    private static final double PORCENTAJE_EXTRA = 0.25;
    private static final double DEDUCCION_SALUD = 0.04;
    private static final double DEDUCCION_PENSION = 0.04;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el número de empleados para Base de Datos: ");
        int N = input.nextInt();
        input.nextLine(); // Limpiar 

        double totalSalarios = 0;
        double minNeto = Double.MAX_VALUE;
        String empleadoMinNeto = "";
        double maxNeto = Double.MIN_VALUE;
        String empleadoMaxNeto = "";

        //realizamos un ciclo para la lectura de cada empleado.

        for (int i = 0; i < N; i++) {

            System.out.print("Cédula del empleado: ");
            String cedula = input.nextLine();

            System.out.print("Nombres y Apellidos del Empleado: ");
            String nombre = input.nextLine();

            System.out.print("Salario Básico: ");
            double salarioBasico = input.nextDouble();

            totalSalarios += salarioBasico;

            System.out.print("Días Laborados: ");
            int diasLaborados = input.nextInt();

            System.out.print("Ventas: ");
            double ventas = input.nextDouble();

            System.out.print("Número de horas extras laboradas: ");
            int horasExtras = input.nextInt();

            System.out.print("Deducciones por préstamos: ");
            double prestamos = input.nextDouble();
            input.nextLine(); 

            double comision = calcularComision(ventas);
            double valorHoraExtra = (salarioBasico + comision) / (30 * 8) * (1 + PORCENTAJE_EXTRA);
            double totalHorasExtras = horasExtras * valorHoraExtra;
            double salud = (salarioBasico * diasLaborados / 30 + comision + totalHorasExtras) * DEDUCCION_SALUD;
            double pension = (salarioBasico * diasLaborados / 30 + comision + totalHorasExtras) * DEDUCCION_PENSION;
            double subsidioTransporte = (salarioBasico <= 2 * SMMLV) ? 0.1 * salarioBasico : 0; 

            double salarioNeto = salarioBasico + comision + totalHorasExtras + subsidioTransporte - prestamos - salud - pension;

            if (salarioNeto < minNeto) {
                minNeto = salarioNeto;
                empleadoMinNeto = nombre;
            }

            if (salarioNeto > maxNeto) {
                maxNeto = salarioNeto;
                empleadoMaxNeto = nombre;
            }


            //se devuelve de la funcion la impresion de los datos 
            imprimirDatos(cedula, nombre, salarioBasico, subsidioTransporte, diasLaborados, ventas, comision, horasExtras, totalHorasExtras, prestamos, salud, pension, salarioNeto);
        }
     
     
        //se hace le calculo
        System.out.println("\nPromedio de salarios básicos: " + (totalSalarios / N));
        System.out.println("Menor salario neto: " + minNeto + " pertenece a " + empleadoMinNeto);
        System.out.println("Mayor salario neto: " + maxNeto + " pertenece a " + empleadoMaxNeto);
    }


//calculamos la comision
    public static double calcularComision(double ventas) {
        return ventas * PORCENTAJE_COMISION;
    }

    //funcion para imprimir los datos
    
    public static void imprimirDatos(String cedula, String nombre, double salarioBasico, double subsidioTransporte, int diasLaborados, double ventas, double comision, int horasExtras, double totalHorasExtras, double prestamos, double salud, double pension, double salarioNeto) {
        System.out.println("\n-------Siguiente Empleado-------------------");
        System.out.println("\n--------------------------");
        System.out.println("Cédula empleado: " + cedula);
        System.out.println("Nombres y Apellidos Empleado: " + nombre);
        System.out.println("Salario Básico: " + salarioBasico);
        System.out.println("Auxilio de Transporte: " + subsidioTransporte);
        System.out.println("Días Laborados: " + diasLaborados);
        System.out.println("Ventas: " + ventas);
        System.out.println("Comisión de Ventas: " + comision);
        System.out.println("Horas Extras: " + horasExtras);
        System.out.println("Total valor horas extras: " + totalHorasExtras);        
        System.out.println("Préstamos: " + prestamos);
        System.out.println("Salud: " + salud);
        System.out.println("Pensión: " + pension);
        System.out.println("Salario Neto a Recibir: " + salarioNeto);
        System.out.println("---------Gracias------------------\n");
        System.out.println("---------------------------\n");
    }
}
    

