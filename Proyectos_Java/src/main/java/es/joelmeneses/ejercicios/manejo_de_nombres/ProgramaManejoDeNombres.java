package es.joelmeneses.ejercicios.manejo_de_nombres;

import javax.swing.*;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {
        String primerNombre= JOptionPane.showInputDialog(null, "Ingrese el primer nombre");
        String segundoNombre= JOptionPane.showInputDialog(null, "Ingrese el segundo nombre");
        String tercerNombre= JOptionPane.showInputDialog(null, "Ingrese el tercer nombre");

        char primerCaracter=Character.toUpperCase(primerNombre.charAt(1));
        JOptionPane.showMessageDialog(null,"El primer nombres es "+primerCaracter);

    }

}
