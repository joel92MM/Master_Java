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
        //System.out.println("Usuarios encontrados en DB: " + usuarios.size());

        return usuarios.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void crearUsuario(UsuarioDTO usuarioDTO) {
        if (existsByEmail(usuarioDTO.getEmail())) {
            throw new RuntimeException("El email " + usuarioDTO.getEmail() + " ya existe");
        }
        usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
    }

    @Override
    public String actualizarUsuario(UsuarioDTO usuarioDTO) {
        // Buscar el usuario real por email
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuarioDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("El usuario " + usuarioDTO.getNombreusuario() + " no existe"));

        // Actualizar solo los campos del DTO que no son null
        usuarioMapper.partialUpdate(usuarioDTO, usuarioExistente);

        // Guardar el usuario actualizado
        usuarioRepository.save(usuarioExistente);

        return "El usuario " + usuarioDTO.getNombreusuario() + " ha sido actualizado correctamente";
    }


    @Override
    public String eliminarUsuario(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("El id " + id + " no existe");
        }
        usuarioRepository.deleteById(id);
        return "El usuario con id " + id + " ha sido eliminado correctamente";
    }

    @Override
    public UsuarioDTO buscarEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.map(usuarioMapper::toDto).orElse(null);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
