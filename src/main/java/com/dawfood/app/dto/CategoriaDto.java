package com.dawfood.app.dto;

import com.dawfood.app.entity.NombreCategoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {
    private Long idCategoria;
    private NombreCategoria nombreCategoria;
    private String nombreSubCategoria;
}
