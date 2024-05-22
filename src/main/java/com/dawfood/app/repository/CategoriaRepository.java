package com.dawfood.app.repository;

import com.dawfood.app.entity.Categoria;
import com.dawfood.app.entity.NombreCategoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findByNombreCategoria(NombreCategoria nombreCategoria);
}