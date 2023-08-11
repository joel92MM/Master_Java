import java.util.Scanner;
/*

La tarea consiste en crear una nueva clase con el método main llamada DetalleDeFactura, se requiere desarrollar un programa que reciba datos de la factura utilizando la clase Scanner de la siguiente manera:

        Reciba el nombre de la factura o descripción, utilizar método nextLine() para obtener el nombre de la factura con espacios.

        Reciba 2 precios de productos de tipo double, utilizar método nextDouble() para obtener precios con decimales (,).

        Calcule el total, sume ambos precios y agregue un valor de impuesto del 19%

        Se pide mostrar en un solo String el nombre de la factura, el monto total bruto (antes de impuesto), el impuesto y el monto total neto incluyendo impuesto.

*/


public class DetalleDeFactura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Nombre de la factura
        System.out.println("Ingrese el nombre de la factura: ");
        String nombre = teclado.nextLine();
        //Precio1
        System.out.println("Ingrese el primer precio: ");
        double precio1 = teclado.nextDouble();

        //Precio2
        System.out.println("Ingrese el segundo precio: ");
        double precio2 = teclado.nextDouble();

        //Suma total
        double totalBruto=precio1+precio2;
        double impuesto=totalBruto*0.19;
        double totalNeto=totalBruto+impuesto;
        System.out.println("La factura "+ nombre+ " tiene un total bruto de "+
                totalBruto+ "€ , con un impuesto de "+ impuesto+ "€ y el monto después" +
                "de impuesto es de "+totalNeto+"€");
    }
}
