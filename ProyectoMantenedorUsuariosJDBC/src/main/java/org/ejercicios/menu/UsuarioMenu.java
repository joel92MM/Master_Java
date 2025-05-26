package menu;


import org.ejercicios.conexion.Conexion;

import java.sql.Connection;
import java.util.Scanner;
import org.ejercicios.modelo.Usuario;
import org.ejercicios.servicios.impl.*;
import org.ejercicios.servicios.*;
import javax.swing.JOptionPane;




public class UsuarioMenu {

    private final UsuarioServicioImpl usuarioServicio = new UsuarioServicioImpl();
    private  final Conexion connection = null ;
    public void iniciarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menu de Usuarios ===");
            System.out.println("1. Listar Usuarios");
            System.out.println("2. Agregar Usuario");
            System.out.println("3. Actualizar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            mostrarMenu(opcion);
    } while (opcion != 5);
        sc.close();    
    }

    public void mostrarMenu(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Obteniendo usuarios...");
                usuarioServicio.obtenerTodos();
                connection.cerrarConexion(connection.obtenerConexion());
                break;
            case 2:
                System.out.println("Insertando usuario...");
                //pedir datos al usuario
                String nombre = JOptionPane.showInputDialog("Introduce el nombre del usuario");
                String password = JOptionPane.showInputDialog("Introduce la password del usuario");
                String email = JOptionPane.showInputDialog("Introduce el email del usuario");
                //crear el usuario
                Usuario usuario = new Usuario();
                usuario.setNombreusuario(nombre);
                usuario.setPassword(password);
                usuario.setEmail(email);
                //insertar el usuario
                usuarioServicio.insertar(usuario);
                break;
            case 3:
                System.out.println("Eliminando usuario...");
                break;
            case 4:
                System.out.println("Listando usuarios...");
                break;
            case 5:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

}
