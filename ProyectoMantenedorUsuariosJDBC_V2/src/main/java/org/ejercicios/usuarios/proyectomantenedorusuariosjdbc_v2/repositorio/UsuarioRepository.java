package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.repositorio;

import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    //Optional<Usuario> buscarIDUsuario(Integer id);
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
