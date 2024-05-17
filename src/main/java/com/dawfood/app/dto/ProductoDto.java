package com.dawfood.app.dto;

import com.dawfood.app.entity.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

    private String nombreProducto;
    private BigDecimal precioProducto;
    private BigDecimal ivaProducto;
    private Integer stockProducto;
    private String descripcion;
    private Categoria categoria;

}