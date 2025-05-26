package org.ejercicios.rest;

import org.ejercicios.modelo.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ejercicios.servicios.impl.UsuarioServicioImpl;


import java.util.List;

@RequestMapping("/api/usuarios")
public class UsuariosRest {
    private final UsuarioServicioImpl usuarioServicio = new UsuarioServicioImpl();


    @GetMapping("/obtener")
    public List<Usuario> obtenerTodos() {
        return usuarioServicio.obtenerTodos();
    }
}
