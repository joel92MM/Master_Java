package es.joelmeneses.ejercicios.manejo_de_nombres;

import javax.swing.*;

public class ProgramaManejoDeNombres {

    public static void main(String[] args) {
        String persona1 = pedirNombreCompleto("Ingrese el nombre completo de la primera persona:");
        String persona2 = pedirNombreCompleto("Ingrese el nombre completo de la segunda persona:");
        String persona3 = pedirNombreCompleto("Ingrese el nombre completo de la tercera persona:");

        String nombre1 = extraerNombre(persona1);
        String nombre2 = extraerNombre(persona2);
        String nombre3 = extraerNombre(persona3);

        String nombreMasLargo = obtenerNombreMasLargo(nombre1, persona1, nombre2, persona2, nombre3, persona3);

        JOptionPane.showMessageDialog(null, nombreMasLargo + " tiene el nombre más largo.");
    }

    private static String pedirNombreCompleto(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    private static String extraerNombre(String nombreCompleto) {
        return nombreCompleto.split(" ")[0]; // obtiene solo el nombre
    }

    private static String obtenerNombreMasLargo(String n1, String p1, String n2, String p2, String n3, String p3) {
        int l1 = n1.length();
        int l2 = n2.length();
        int l3 = n3.length();

        if (l1 >= l2 && l1 >= l3) {
            return p1;
        } else if (l2 >= l1 && l2 >= l3) {
            return p2;
        } else {
            return p3;
        }
    }
}
