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
    private Long idCategoria;

    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    @Column(name = "nombreSubCategoria")
    private String nombreSubCategoria;

}