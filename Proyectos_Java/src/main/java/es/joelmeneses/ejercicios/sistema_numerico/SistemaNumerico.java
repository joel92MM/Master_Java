package es.joelmeneses.ejercicios.sistema_numerico;

import javax.swing.*;
import java.util.Scanner;

public class SistemaNumerico {
    public static void main(String[] args) {
        String numero1= JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String numero2= JOptionPane.showInputDialog(null, "Ingrese el segundo numero");

        Integer resultado= Integer.parseInt(numero1)+Integer.parseInt(numero2);

        JOptionPane.showMessageDialog(null,resultado);

        Scanner teclado = new Scanner(System.in);
//        int numero1Scaner=System.out.println("Ingrese el primer numero");


    }
}
