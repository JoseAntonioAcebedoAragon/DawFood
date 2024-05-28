package com.dawfood.app.service;

import com.dawfood.app.dto.CategoriaDto;
import com.dawfood.app.entity.Categoria;
import com.dawfood.app.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpringServiceGet {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // TODO --> FUNCIONA, PERO HAY QUE REVISARLO, PARA QUITAR EL ID Y PONER FORMATO JSON
    public CategoriaDto verCategoria(Long idCategoria) {
        Optional<Categoria> opt = categoriaRepository.findById(idCategoria);
        if (opt.isPresent()) {
            Categoria categoria = opt.get();
            return new CategoriaDto(categoria.getIdCategoria(), categoria.getNombreCategoria(), categoria.getNombreSubCategoria());
        } else {
            return null;
        }
    }

}