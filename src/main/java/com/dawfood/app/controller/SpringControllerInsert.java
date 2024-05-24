package com.dawfood.app.controller;

import com.dawfood.app.service.SpringServiceInsert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SpringControllerInsert {

    @Autowired
    private SpringServiceInsert springServiceInsert;

    @PostMapping("/insertarCategoria")
    public String insertarCategoria(@RequestBody() String json) {

        // Llama a un método del servicio para insertar en la base de datos y retorna el resultado
        return (springServiceInsert.insertarCategoria(json));
    }

//    @GetMapping("/insertarDetallePedido")
//    public String insertarDetallePedido(@RequestParam(value = "pedido") Pedido pedido,
//                                        @RequestParam(value = "producto") Producto producto,
//                                        @RequestParam(value = "cantidadProducto") Integer cantidadProducto) {
//        return (springServiceInsert.insertarDetallePedido(pedido, producto, cantidadProducto));
//    }
//
//    @GetMapping("/insertarPedido")
//    public String insertarPedido(@RequestParam(value = "precioPedido") BigDecimal precioPedido,
//                                 @RequestParam(value = "idTransaccion") String idTransaccion) {
//        return (springServiceInsert.insertarPedido(precioPedido, idTransaccion));
//    }
//
//    @GetMapping("/insertarProducto")
//    public String insertarProducto(@RequestParam(value = "nombreProducto") String nombreProducto,
//                                   @RequestParam(value = "precioProducto") BigDecimal precioProducto,
//                                   @RequestParam(value = "ivaProducto") BigDecimal ivaProducto,
//                                   @RequestParam(value = "stockProducto") Integer stockProducto,
//                                   @RequestParam(value = "descripcion") String descripcion,
//                                   @RequestParam(value = "categoria") Categoria categoria) {
//        return (springServiceInsert.insertarProducto(nombreProducto, precioProducto, ivaProducto, stockProducto, descripcion, categoria));
//    }
//
//    @GetMapping("/insertarUsuario")
//    public String insertarUsuario(@RequestParam(value = "nombreUsuario") String nombreUsuario,
//                                  @RequestParam(value = "correoElectronico") String correoElectronico,
//                                  @RequestParam(value = "contrasena") String contrasena) {
//        return (springServiceInsert.insertarUsuario(nombreUsuario, correoElectronico, contrasena));
//    }

}