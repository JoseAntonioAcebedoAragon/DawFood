package com.dawfood.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {
    private Long idPedido;
    private LocalDateTime fechaHoraPedido;
    private BigDecimal precioPedido;
    private String idTransaccion;
    private List<DetallePedidoDto> detalles;
}
