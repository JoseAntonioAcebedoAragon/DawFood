package com.dawfood.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "nombreUsuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "correoElectronico", nullable = false)
    private String correoElectronico;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

}