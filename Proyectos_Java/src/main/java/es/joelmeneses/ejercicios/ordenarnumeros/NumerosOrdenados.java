package es.joelmeneses.ejercicios.ordenarnumeros;

import javax.swing.*;

/*El desafío es un programa que pida dos números y los muestre ordenados de
        mayor a menor.

        Podría ser utilizando operador ternario.*/
public class NumerosOrdenados {
    public static void main(String[] args) {
        int numero1= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el primer numero"));
        int numero2= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el segundo numero"));


    }
    public static int mayorNumero(int primerNumero, int segundoNumero){
        int numeros[];

        return (primerNumero>segundoNumero)?primerNumero:segundoNumero;
    }
}
