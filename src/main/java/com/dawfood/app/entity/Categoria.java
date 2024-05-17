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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long idCategoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombreCategoria", nullable = false)
    private String nombreCategoria;

    @Column(name = "nombreSubCategoria", nullable = false)
    private String nombreSubCategoria;

}