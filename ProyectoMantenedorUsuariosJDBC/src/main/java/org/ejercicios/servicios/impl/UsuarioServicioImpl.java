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

    }

    @Override
    public void eliminar(Usuario usuario) {
        if (existe(usuario)) {
            usuarioDAO.delete(usuario);
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
    public boolean existe(Usuario usuario) {
        return usuarioDAO.existe(usuario.getEmail());
    }

}
