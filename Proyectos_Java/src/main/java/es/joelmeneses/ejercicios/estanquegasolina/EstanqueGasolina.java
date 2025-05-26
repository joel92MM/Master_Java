package es.joelmeneses.ejercicios.estanquegasolina;

import java.util.Scanner;

/*Suponiendo un estanque de gasolina (gas) con capacidad 70 litros, se requiere un programa que pida la medida actual en litros y mostrar el resultado de la forma: Insuficiente, Suficiente, Medio...

        La medida o capacidad actual del estanque puede ser en tipo double, para una mejor precisión, pero tambien puede ser del tipo int.

        Si la capacidad actual es 70 litros: imprimir Estanque lleno

        Si está entre 60 y menor a 70: imprimir Estanque casi lleno

        Si está entre 40 y menor a 60: imprimir Estanque  3/4

        Si está entre 35 y menor a 40: imprimir Medio Estanque

        Si está entre 20 y menor a 35: imprimir Suficiente

        Si está entre 1 y menor a 20: imprimir Insuficiente*/
public class EstanqueGasolina {
    public static void main(String[] args) {
        double medida = leerMedidaActual();
        String estado = evaluarNivelEstanque(medida);
        System.out.println(estado);
    }

    // Método para leer la medida actual del estanque
    private static double leerMedidaActual() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa la medida actual del estanque en litros: ");
        double litros = sc.nextDouble();
        sc.close();
        return litros;
    }

    // Método para evaluar el nivel del estanque y devolver el estado correspondiente
    private static String evaluarNivelEstanque(double litros) {
        if (litros < 1 || litros > 70) return "Valor no válido";

        if (litros == 70) return "Estanque lleno";
        if (litros >= 60) return "Estanque casi lleno";
        if (litros >= 40) return "Estanque 3/4";
        if (litros >= 35) return "Medio Estanque";
        if (litros >= 20) return "Suficiente";
        return "Insuficiente";
    }
}
