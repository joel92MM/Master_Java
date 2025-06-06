package org.ejercicios.usuarios.proyectomantenedorusuariosjdbc_v2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("'Chiquito de la calzada'")
    @Column(name = "nombreusuario", length = 50)
    private String nombreusuario;

    @Column(name = "password", length = 60)
    private String password;

    @ColumnDefault("'delacalzada@gmail.com'")
    @Column(name = "email", length = 45)
    private String email;

}