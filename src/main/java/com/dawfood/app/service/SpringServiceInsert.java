package com.dawfood.app.service;

import com.dawfood.app.entity.*;
import com.dawfood.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SpringServiceInsert {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String insertarCategoria(NombreCategoria nombreCategoria, String nombreSubCategoria) {

        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(nombreCategoria);
        categoria.setNombreSubCategoria(nombreSubCategoria);
        categoriaRepository.save(categoria);

        return "La categoria se ha insertado correctamente.";
    }

    public String insertarDetallePedido(Pedido pedido, Producto producto, Integer cantidadProducto) {

        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setPedido(pedido);
        detallePedido.setProducto(producto);
        detallePedido.setCantidadProducto(cantidadProducto);
        detallePedidoRepository.save(detallePedido);

        return "Los detalles del pedido se han insertado correctamente.";
    }

    public String insertarPedido(BigDecimal precioPedido, String idTransaccion) {

        Pedido pedido = new Pedido();
        pedido.setPrecioPedido(precioPedido);
        pedido.setIdTransaccion(idTransaccion);
        pedidoRepository.save(pedido);

        return "El pedido se ha insertado correctamente.";
    }

    public String insertarProducto(String nombreProducto, BigDecimal precioProducto, BigDecimal ivaProducto, Integer stockProducto, String descripcion, Categoria categoria) {

        Producto producto = new Producto();
        producto.setNombreProducto(nombreProducto);
        producto.setPrecioProducto(precioProducto);
        producto.setIvaProducto(ivaProducto);
        producto.setStockProducto(stockProducto);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoria);
        productoRepository.save(producto);

        return "El producto se ha insertado correctamente.";
    }

    public String insertarUsuario(String nombreUsuario, String correoElectronico, String contrasena) {

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setContrasena(contrasena);
        usuarioRepository.save(usuario);

        return "El usuario se ha insertado correctamente.";
    }

}
