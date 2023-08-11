import java.util.Scanner;

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
