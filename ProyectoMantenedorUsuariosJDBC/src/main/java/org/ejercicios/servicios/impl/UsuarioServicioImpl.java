package org.ejercicios.servicios.impl;

import org.ejercicios.dao.impl.UsuarioDAOImpl;
import org.ejercicios.modelo.Usuario;
import org.ejercicios.servicios.UsuarioServicio;

import java.util.List;


public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

    @Override
    public void insertar(Usuario usuario) {

        usuarioDAO.save(usuario);
    }


    @Override
    public void actualizar(Usuario usuario) {
        if (!existe(usuario.getEmail())) {
            System.out.println("El usuario con email " + usuario.getEmail() + " no existe\n\t");
            return;
        }
        usuarioDAO.update(usuario);
        System.out.println("Se actualizo el usuario correctamente\n\t");
    }

    @Override
    public void eliminar(String email) {
        if (existe(email)) {
            usuarioDAO.delete(email);
            System.out.println("Se elimino el usuario correctamente\n\t");
        } else {
            System.out.println("El usuario no existe\n\t");
        }
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioDAO.listar();
    }

    @Override
    public boolean existe(String email) {
        return usuarioDAO.existe(email);
    }

}
