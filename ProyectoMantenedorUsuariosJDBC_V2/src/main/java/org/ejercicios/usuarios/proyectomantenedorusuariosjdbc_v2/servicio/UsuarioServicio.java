package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.servicio;

import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioServicio {


    List<UsuarioDTO> obtenerUsuarios() ;

    void crearUsuario(UsuarioDTO usuarioDTO);

    void actualizarUsuario(UsuarioDTO usuarioDTO);

    void eliminarUsuario(Integer id);

    UsuarioDTO buscarEmail(String email);

}
