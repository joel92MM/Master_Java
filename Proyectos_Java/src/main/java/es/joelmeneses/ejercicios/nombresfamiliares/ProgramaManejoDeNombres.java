package es.joelmeneses.ejercicios.nombresfamiliares;
/*
La tarea consiste en crear una clase llamada ProgramaManejoDeNombres de la siguiente manera:

        Se requiere desarrollar un programa que reciba los nombres de 3 integrantes de tu familia o amigos como argumentos de línea de comandos.

        Se pide por cada nombre de la persona una nueva variable del tipo String al tomar el segundo carácter pero convertido en mayúscula y se le concatena un punto y los dos últimos caracteres de la persona.
        Por ejemplo para Andres debe quedar como N.es

        Debe imprimir como resultado los tres nuevos nombres separado con guion bajo (como una única variable).

        Ejemplo, un resultado final esperado para los nombres Andres, Maria y Pepe podría ser:

        N.es_A.ia_E.pe*/

import javax.swing.*;

public class ProgramaManejoDeNombres {
    public static void main(String[] args) {
        String primerNombre= JOptionPane.showInputDialog(null, "Ingrese el primer nombre");
        String segundoNombre= JOptionPane.showInputDialog(null, "Ingrese el segundo nombre");
        String tercerNombre= JOptionPane.showInputDialog(null, "Ingrese el segundo nombre");

    }
}
