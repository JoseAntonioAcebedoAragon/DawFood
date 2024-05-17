package com.dawfood.app.repository;

import com.dawfood.app.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}