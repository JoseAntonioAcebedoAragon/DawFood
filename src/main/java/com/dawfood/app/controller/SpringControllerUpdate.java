package com.dawfood.app.controller;

import com.dawfood.app.service.SpringServiceUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SpringControllerUpdate {

    @Autowired
    private final SpringServiceUpdate springServiceUpdate;

    @PutMapping("/actualizarCategoria/{idcategoria}")
    public String actualizarCategoria(@PathVariable(value = "idcategoria") Long idCategoria,
                                 @RequestBody String json) {
        return springServiceUpdate.actualizarCategoria(idCategoria, json);
    }

    /*
        http://localhost:8080/actualizarCategoria/1
        {
            "nombreCategoria": "COMIDA",
            "nombreSubCategoria": "Pizza"
        }
    */

    @PutMapping("/actualizarDetallePedido/{idpedido}/{idproducto}")
    public String actualizarDetallePedido(@PathVariable(value = "idpedido") Long idPedido,
                                          @PathVariable(value = "idproducto") Long idProducto,
                                          @RequestBody String json) {
        return springServiceUpdate.actualizarDetallePedido(idPedido, idProducto, json);
    }

    /*
        http://localhost:8080/actualizarDetallePedido/1/1
        {
            "cantidadProducto": 2
        }
    */

    @PutMapping("/actualizarPedido/{idpedido}")
    public String actualizarPedido(@PathVariable(value = "idpedido") Long idPedido,
                                      @RequestBody String json) {
        return springServiceUpdate.actualizarPedido(idPedido, json);
    }

    /*
        http://localhost:8080/actualizarPedido/1
        {
            "precioPedido": 45.99
        }
    */

    @PutMapping("/actualizarProducto/{idproducto}")
    public String actualizarProducto(@PathVariable(value = "idproducto") Long idProducto,
                                   @RequestBody String json) {
        return springServiceUpdate.actualizarProducto(idProducto, json);
    }

    /*
        http://localhost:8080/actualizarProducto/1
        {
            "nombreProducto": "Producto01",
            "precioProducto": 10.99,
            "ivaProducto": 0.21,
            "stockProducto": 100,
            "descripcion": "Producto01",
            "categoria": {
                "idCategoria": 1
            }
        }
    */

    @PutMapping("/actualizarUsuario/{idusuario}")
    public String actualizarUsuario(@PathVariable(value = "idusuario") Long idUsuario,
                                      @RequestBody String json) {
        return springServiceUpdate.actualizarUsuario(idUsuario, json);
    }

        /*
        http://localhost:8080/actualizarUsuario/1
        {
            "nombreUsuario": "Usuario02",
            "correoElectronico": "usuario02@gmail.com",
            "contrasena": "Usuario02"
        }
    */

}