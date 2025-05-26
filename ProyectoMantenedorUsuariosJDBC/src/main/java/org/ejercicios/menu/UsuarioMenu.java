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
                System.out.println("Actualizando usuario...");
                // Paso 1: Pedir email
                String emailActualizar = JOptionPane.showInputDialog("Introduce el email del usuario a actualizar:");
                if (emailActualizar == null || emailActualizar.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email no puede estar vacío.");
                    break;
                }

                // Paso 2: Verificar si existe el usuario
                if (!usuarioServicio.existe(emailActualizar)) {
                    JOptionPane.showMessageDialog(null, "El usuario con email " + emailActualizar + " no existe.");
                    break;
                }
                String[] opciones = {"Nombre de usuario", "Contraseña", "Ambos"};
                int opcioncase = JOptionPane.showOptionDialog(
                        null,
                        "¿Qué quieres actualizar?",
                        "Actualizar usuario",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );

                String nuevoNombre = null;
                String nuevaPassword = null;

                if (opcioncase == 0) { // Nombre de usuario
                    nuevoNombre = JOptionPane.showInputDialog("Introduce el nuevo nombre de usuario:");
                } else if (opcioncase == 1) { // Contraseña
                    nuevaPassword = JOptionPane.showInputDialog("Introduce la nueva contraseña:");
                } else if (opcioncase == 2) { // Ambos
                    nuevoNombre = JOptionPane.showInputDialog("Introduce el nuevo nombre de usuario:");
                    nuevaPassword = JOptionPane.showInputDialog("Introduce la nueva contraseña:");
                }
                // Construir el objeto Usuario para actualizar
                Usuario usuarioActualizar = new Usuario();
                usuarioActualizar.setEmail(emailActualizar);

                // Solo setear si no están vacíos (para que el DAO actualice solo esos campos)
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    usuarioActualizar.setNombreusuario(nuevoNombre.trim());
                }

                if (nuevaPassword != null && !nuevaPassword.trim().isEmpty()) {
                    usuarioActualizar.setPassword(nuevaPassword.trim());
                }

                // Actualizar usuario usando el servicio
                try {
                    usuarioServicio.actualizar(usuarioActualizar);
                    JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
                }
                break;
            case 4:
                System.out.println("Eliminando usuario...");
                String emailEliminar = JOptionPane.showInputDialog("Introduce el email del usuario para eliminarlo");
                usuarioServicio.eliminar(emailEliminar);
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
