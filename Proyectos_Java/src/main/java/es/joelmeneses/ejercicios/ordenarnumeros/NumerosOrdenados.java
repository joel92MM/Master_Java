package es.joelmeneses.ejercicios.ordenarnumeros;

import javax.swing.*;
import java.util.Scanner;

/*El desafío es un programa que pida dos números y los muestre ordenados de
        mayor a menor.

        Podría ser utilizando operador ternario.*/
public class NumerosOrdenados {
    public static void main(String[] args) {
        int numero1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el primer numero"));
        int numero2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el segundo numero"));

        System.out.println(ordenarDescendente(numero1, numero2));
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return new Scanner(System.in).nextInt();
    }

    private static String ordenarDescendente(int a, int b) {
        if (a == b) {
            return "Ambos números son iguales: " + a;
        }
        int mayor = Math.max(a, b);
        int menor = Math.min(a, b);
        return "Ordenados de mayor a menor: " + mayor + " y " + menor;
    }
}
