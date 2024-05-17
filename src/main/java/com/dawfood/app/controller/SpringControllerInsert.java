package com.dawfood.app.controller;

import com.dawfood.app.entity.Categoria;
import com.dawfood.app.entity.Pedido;
import com.dawfood.app.entity.Producto;
import com.dawfood.app.service.SpringServiceInsert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class SpringControllerInsert {

    @Autowired
    private SpringServiceInsert springServiceInsert;

    @GetMapping("/insertarCategoria")
    public String insertarCategoria(@RequestParam(value = "nombreCategoria") String nombreCategoria,
                                    @RequestParam(value = "nombreSubCategoria") String nombreSubCategoria) {
        return springServiceInsert.insertarCategoria(nombreCategoria, nombreSubCategoria);
    }

    @GetMapping("/insertarDetallePedido")
    public String insertarDetallePedido(@RequestParam(value = "pedido") Pedido pedido,
                                        @RequestParam(value = "producto") Producto producto,
                                        @RequestParam(value = "cantidadProducto") Integer cantidadProducto) {
        return springServiceInsert.insertarDetallePedido(pedido, producto, cantidadProducto);
    }

    @GetMapping("/insertarPedido")
    public String insertarPedido(@RequestParam(value = "precioPedido") BigDecimal precioPedido,
                                 @RequestParam(value = "idTransaccion") String idTransaccion) {
        return springServiceInsert.insertarPedido(precioPedido, idTransaccion);
    }

    @GetMapping("/insertarProducto")
    public String insertarProducto(@RequestParam(value = "nombreProducto") String nombreProducto,
                                   @RequestParam(value = "precioProducto") BigDecimal precioProducto,
                                   @RequestParam(value = "ivaProducto") BigDecimal ivaProducto,
                                   @RequestParam(value = "stockProducto") Integer stockProducto,
                                   @RequestParam(value = "descripcion") String descripcion,
                                   @RequestParam(value = "categoria") Categoria categoria) {
        return springServiceInsert.insertarProducto(nombreProducto, precioProducto, ivaProducto, stockProducto, descripcion, categoria);
    }

    @GetMapping("/insertarUsuario")
    public String insertarUsuario(@RequestParam(value = "nombreUsuario") String nombreUsuario,
                                  @RequestParam(value = "correoElectronico") String correoElectronico,
                                  @RequestParam(value = "contrasena") String contrasena) {
        return springServiceInsert.insertarUsuario(nombreUsuario, correoElectronico, contrasena);
    }

}