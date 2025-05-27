package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.restController;

import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.dto.UsuarioDTO;
import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioServicio.obtenerUsuarios();
    }
}
