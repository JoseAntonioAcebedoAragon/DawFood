package com.dawfood.app.controller;

import com.dawfood.app.entity.Categoria;
import com.dawfood.app.entity.Pedido;
import com.dawfood.app.entity.Producto;
import com.dawfood.app.service.SpringServiceInsert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Slf4j
public class SpringControllerInsert {

    @Autowired
    private SpringServiceInsert springServiceInsert;

    @PostMapping("/insertarCategoria")
    public String insertarCategoria(@RequestBody String json) {
        return springServiceInsert.insertarCategoria(json);
    }

    /*
        http://localhost:8080/insertarCategoria
        {
            "nombreCategoria": "COMIDA",
            "nombreSubCategoria": "Pizza"
        }
    */

    @PostMapping("/insertarDetallePedido")
    public String insertarDetallePedido(@RequestBody String json) {
        return (springServiceInsert.insertarDetallePedido(json));
    }

    /*
        http://localhost:8080/insertarDetallePedido
        {
            "idPedido": 1,
            "idProducto": 1,
            "cantidadProducto": 2
        }
    */

    @PostMapping("/insertarPedido")
    public String insertarPedido(@RequestBody String json) {
        return (springServiceInsert.insertarPedido(json));
    }

    /*
        http://localhost:8080/insertarPedido
        ... AÑADIR ...
    */

    @PostMapping("/insertarProducto")
    public String insertarProducto(@RequestBody String json) {
        return (springServiceInsert.insertarProducto(json));
    }
    /*
        http://localhost:8080/insertarProducto
        {
            "nombreProducto": "Producto02",
            "precioProducto": 10.99,
            "ivaProducto": 0.21,
            "stockProducto": 100,
            "descripcion": "Producto02",
            "categoria": {
                "idCategoria": 1
            }
        }
    */

    @PostMapping("/insertarUsuario")
    public String insertarUsuario(@RequestBody String json) {
        return (springServiceInsert.insertarUsuario(json));
    }

    /*
        http://localhost:8080/insertarUsuario
        {
            "nombreUsuario": "Usuario01",
            "correoElectronico": "usuario01@gmail.com",
            "contrasena": "Usuario01"
        }
    */

}