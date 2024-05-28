package com.dawfood.app.repository;

import com.dawfood.app.entity.DetallePedido;
import com.dawfood.app.entity.DetallePedidoId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedido, DetallePedidoId> {
}