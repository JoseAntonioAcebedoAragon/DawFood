package com.dawfood.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "categoria")
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCategoria")
    private long idCategoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombreCategoria", nullable = false)
    private NombreCategoria nombreCategoria;

    @Column(name = "nombreSubCategoria", nullable = false)
    private String nombreSubCategoria;

}