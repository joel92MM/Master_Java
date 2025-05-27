package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String nombreusuario;
    private String password;
    private String email;

}
