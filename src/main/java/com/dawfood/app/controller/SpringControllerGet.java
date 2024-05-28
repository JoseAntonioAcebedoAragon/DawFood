package com.dawfood.app.controller;

import com.dawfood.app.dto.CategoriaDto;
import com.dawfood.app.entity.Categoria;
import com.dawfood.app.service.SpringServiceGet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SpringControllerGet {

    private final SpringServiceGet springServiceGet;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // TODO --> FUNCIONA, PERO HAY QUE REVISARLO, PARA QUITAR EL ID Y PONER FORMATO JSON
    @GetMapping("/verCategoria/{idcategoria}")
    public String verCategoria(@PathVariable(value = "idcategoria") Long idCategoria) {
        CategoriaDto c1 = springServiceGet.verCategoria(idCategoria);

        if (c1 == null) {
            return "Categoría no encontrada.";
        }

        try {
            return objectMapper.writeValueAsString(c1);
        } catch (JsonProcessingException e) {
            return "Error al procesar el JSON.";
        }
    }

    /*
        http://localhost:8080/verCategoria/1
    */

}