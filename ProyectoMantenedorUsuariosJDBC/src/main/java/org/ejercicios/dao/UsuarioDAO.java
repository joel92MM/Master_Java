package org.ejercicios.dao;

import org.ejercicios.modelo.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(String email);
    boolean existe(String email);
    List<Usuario> listar();
    Usuario findById(int id);
    Usuario findByEmail(String email);
}
