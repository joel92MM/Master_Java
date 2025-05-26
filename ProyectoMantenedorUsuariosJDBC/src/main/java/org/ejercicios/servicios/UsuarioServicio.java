package org.ejercicios.servicios;

import java.util.List;
import org.ejercicios.modelo.Usuario;

public interface UsuarioServicio {

     void insertar(Usuario usuario);
     void actualizar(Usuario usuario);
     void eliminar(String email);
     List<Usuario> obtenerTodos();
     boolean existe(String email);
     

}
