package com.dawfood.app.dto;

import com.dawfood.app.entity.Pedido;
import com.dawfood.app.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDto {

    private Pedido pedido;
    private Producto producto;
    private Integer cantidadProducto;

}