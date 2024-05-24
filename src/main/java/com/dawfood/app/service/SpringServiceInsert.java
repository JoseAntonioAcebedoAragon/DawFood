package com.dawfood.app.service;

import com.dawfood.app.dto.CategoriaDto;
import com.dawfood.app.entity.*;
import com.dawfood.app.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringServiceInsert {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String insertarCategoria(String json) {

        try {
            CategoriaDto categoriaDto = objectMapper.readValue(json, CategoriaDto.class);
            Categoria categoria = new Categoria();
            categoria.setNombreCategoria(categoriaDto.getNombreCategoria());
            categoria.setNombreSubCategoria(categoriaDto.getNombreSubCategoria());
            categoriaRepository.save(categoria);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return "La categoria se ha insertado correctamente.";

    }

//    public String insertarDetallePedido(Pedido pedido, Producto producto, Integer cantidadProducto) {
//
//        DetallePedido detallePedido = new DetallePedido();
//        detallePedido.setPedido(pedido);
//        detallePedido.setProducto(producto);
//        detallePedido.setCantidadProducto(cantidadProducto);
//        detallePedidoRepository.save(detallePedido);
//
//        return "Los detalles del pedido se han insertado correctamente.";
//    }
//
//    public String insertarPedido(BigDecimal precioPedido, String idTransaccion) {
//
//        Pedido pedido = new Pedido();
//        pedido.setPrecioPedido(precioPedido);
//        pedido.setIdTransaccion(idTransaccion);
//        pedidoRepository.save(pedido);
//
//        return "El pedido se ha insertado correctamente.";
//    }
//
//    public String insertarProducto(String nombreProducto, BigDecimal precioProducto, BigDecimal ivaProducto, Integer stockProducto, String descripcion, Categoria categoria) {
//
//        Producto producto = new Producto();
//        producto.setNombreProducto(nombreProducto);
//        producto.setPrecioProducto(precioProducto);
//        producto.setIvaProducto(ivaProducto);
//        producto.setStockProducto(stockProducto);
//        producto.setDescripcion(descripcion);
//        producto.setCategoria(categoria);
//        productoRepository.save(producto);
//
//        return "El producto se ha insertado correctamente.";
//    }
//
//    public String insertarUsuario(String nombreUsuario, String correoElectronico, String contrasena) {
//
//        Usuario usuario = new Usuario();
//        usuario.setNombreUsuario(nombreUsuario);
//        usuario.setCorreoElectronico(correoElectronico);
//        usuario.setContrasena(contrasena);
//        usuarioRepository.save(usuario);
//
//        return "El usuario se ha insertado correctamente.";
//    }

}
