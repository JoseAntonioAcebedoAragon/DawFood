package com.dawfood.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDto {
    private Long idPedido;
    private Long idProducto;
    private Integer cantidadProducto;
}