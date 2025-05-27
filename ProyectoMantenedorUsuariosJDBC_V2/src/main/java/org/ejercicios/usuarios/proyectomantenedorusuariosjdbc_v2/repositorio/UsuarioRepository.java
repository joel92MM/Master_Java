package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.repositorio;

import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    Usuario buscarIDUsuario(Integer id);
    Usuario findByEmail(String email);
    boolean existsByEmail(String email);
}
