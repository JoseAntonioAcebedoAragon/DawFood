package com.dawfood.app.controller;

import com.dawfood.app.service.SpringServiceDelete;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SpringControllerDelete {

    @Autowired
    private SpringServiceDelete springServiceDelete;

    @DeleteMapping("/eliminarCategoria/{idcategoria}")
    public String deleteCategoria(@PathVariable(value = "idcategoria") Long idCategoria) {
        return springServiceDelete.deleteCategoria(idCategoria);
    }

    /*
        http://localhost:8080/eliminarCategoria/1
    */

    @DeleteMapping("/eliminarPedido/{idpedido}")
    public String deletePedido(@PathVariable(value = "idpedido") Long idPedido) {
        return springServiceDelete.deletePedido(idPedido);
    }

    /*
        http://localhost:8080/eliminarPedido/1
    */

    @DeleteMapping("/eliminarProducto/{idproducto}")
    public String deleteProducto(@PathVariable(value = "idproducto") Long idProducto) {
        return springServiceDelete.deleteProducto(idProducto);
    }

    /*
        http://localhost:8080/eliminarProducto/1
    */

    @DeleteMapping("/eliminarUsuario/{idusuario}")
    public String deleteUsuario(@PathVariable(value = "idusuario") Long idUsuario) {
        return springServiceDelete.deleteUsuario(idUsuario);
    }

    /*
        http://localhost:8080/eliminarUsuario/1
    */

    @DeleteMapping("/eliminarDetallePedido/{idpedido}/{idproducto}")
    public String deleteUsuario(@PathVariable(value = "idpedido") Long idPedido,
                                @PathVariable(value = "idproducto") Long idProducto) {
        return springServiceDelete.deleteDetallePedido(idPedido, idProducto);
    }

    /*
        http://localhost:8080/eliminarDetallePedido/1/1
    */

}