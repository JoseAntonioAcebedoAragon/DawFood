package com.dawfood.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "detallepedido")
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;

    @Id
    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(name = "cantidadProducto", nullable = false)
    private Integer cantidadProducto;

}