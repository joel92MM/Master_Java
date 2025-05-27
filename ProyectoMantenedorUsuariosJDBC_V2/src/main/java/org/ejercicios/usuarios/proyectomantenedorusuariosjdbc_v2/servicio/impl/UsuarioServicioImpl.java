package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.servicio.impl;

import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.dto.UsuarioDTO;
import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.entity.Usuario;
import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.mapper.UsuarioMapper;
import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.repositorio.UsuarioRepository;
import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void crearUsuario(UsuarioDTO usuarioDTO) {

    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuarioDTO) {

    }

    @Override
    public void eliminarUsuario(Integer id) {

    }

    @Override
    public UsuarioDTO buscarEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.map(usuarioMapper::toDto).orElse(null);
    }
}
