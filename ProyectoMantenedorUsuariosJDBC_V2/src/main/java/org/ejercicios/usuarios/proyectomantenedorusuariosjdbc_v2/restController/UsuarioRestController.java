package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.restController;

import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.dto.UsuarioDTO;
import org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/buscar")
    public UsuarioDTO buscarEmail(String email){
        return usuarioServicio.buscarEmail(email);
    }
    @GetMapping("/existe")
    public boolean existsByEmail(String email){
        return usuarioServicio.existsByEmail(email);
    }
    @DeleteMapping("/eliminar")
    public String eliminarUsuario(Integer id){
        return usuarioServicio.eliminarUsuario(id);
    }
    @PostMapping("/crear")
    public void crearUsuario(UsuarioDTO usuarioDTO){
        usuarioServicio.crearUsuario(usuarioDTO);
    }
    @PutMapping("/{email}")
    public ResponseEntity<String> actualizarUsuario(
            @PathVariable String email,
            @RequestBody UsuarioDTO usuarioDTO){
        try {
            if(!usuarioServicio.existsByEmail(email)){
                return ResponseEntity.badRequest().body("El usuario no existe");
            }

            usuarioDTO.setEmail(email);
            String mensaje = usuarioServicio.actualizarUsuario(usuarioDTO);
            return ResponseEntity.ok(mensaje);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
