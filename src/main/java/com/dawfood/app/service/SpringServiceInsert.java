package com.dawfood.app.service;

import com.dawfood.app.dto.*;
import com.dawfood.app.entity.*;
import com.dawfood.app.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private ObjectMapper objectMapper;

    public String insertarCategoria(String json) {
        try {
            CategoriaDto categoriaDto = objectMapper.readValue(json, CategoriaDto.class);
            Categoria categoria = new Categoria();
            categoria.setNombreCategoria(categoriaDto.getNombreCategoria());
            categoria.setNombreSubCategoria(categoriaDto.getNombreSubCategoria());
            categoriaRepository.save(categoria);
            return "La categoria se ha insertado correctamente.";
        } catch (JsonProcessingException e) {
            return "Error al insertar la categoria.";
        }
    }

    public String insertarDetallePedido(String json) {
        try {
            DetallePedidoDto detallePedidoDto = objectMapper.readValue(json, DetallePedidoDto.class);

            // Buscar el pedido y el producto en la base de datos
            Pedido pedido = pedidoRepository.findById(detallePedidoDto.getIdPedido()).orElse(null);
            Producto producto = productoRepository.findById(detallePedidoDto.getIdProducto()).orElse(null);

            // Validar que el pedido y el producto existan
            if (pedido == null) {
                return "El pedido especificado no existe.";
            }
            if (producto == null) {
                return "El producto especificado no existe.";
            }

            // Crear el detalle del pedido y guardarlo
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPedido(pedido);
            detallePedido.setProducto(producto);
            detallePedido.setCantidadProducto(detallePedidoDto.getCantidadProducto());
            detallePedidoRepository.save(detallePedido);

            return "El detalle del pedido se ha insertado correctamente.";
        } catch (JsonProcessingException e) {
            return "Error al insertar el detalle del pedido.";
        }
    }

    public String insertarPedido(String json) {
        try {
            PedidoDto pedidoDto = objectMapper.readValue(json, PedidoDto.class);

            // Buscar el pedido y el producto en la base de datos
            Usuario usuario = usuarioRepository.findById(pedidoDto.getIdPedido()).orElse(null);

            // Validar que el pedido y el producto existan
            if (usuario == null) {
                return "El usuario especificado no existe.";
            }

            // Crear el detalle del pedido y guardarlo
            Pedido pedido = new Pedido();
            pedido.setPrecioPedido(pedidoDto.getPrecioPedido());
            pedido.setIdTransaccion(pedidoDto.getIdTransaccion());
            pedido.setUsuario(usuario);
            pedidoRepository.save(pedido);

            return "El pedido se ha insertado correctamente.";
        } catch (JsonProcessingException e) {
            return "Error al insertar el pedido.";
        }
    }


    public String insertarProducto(String json) {
        try {
            ProductoDto productoDto = objectMapper.readValue(json, ProductoDto.class);
            Producto producto = new Producto();
            producto.setNombreProducto(productoDto.getNombreProducto());
            producto.setPrecioProducto(productoDto.getPrecioProducto());
            producto.setIvaProducto(productoDto.getIvaProducto());
            producto.setStockProducto(productoDto.getStockProducto());
            producto.setDescripcion(productoDto.getDescripcion());

            // Obtenemos la categoría del producto
            CategoriaDto categoriaDto = productoDto.getCategoria();
            if (categoriaDto == null) {
                return "La categoría no puede ser nula.";
            }

            // Verificamos si la categoría existe en la base de datos
                // Aquí el problema es que idCategoria en la bd se pone solo, autoincrement, por lo que no hay
                // que ponerlo en java, y por eso da este problema, ya que he quitado del CategorioDTO el idCategoria.
            Categoria categoria = categoriaRepository.findById(categoriaDto.getIdCategoria())
                    .orElse(null);

            if (categoria == null) {
                return "La categoría especificada no existe.";
            }

            // Asignamos la categoría al producto
            producto.setCategoria(categoria);

            // Guardamos el producto en la base de datos
            productoRepository.save(producto);

            return "El producto se ha insertado correctamente.";
        } catch (JsonProcessingException e) {
            return "Error al insertar el producto.";
        }
    }

    public String insertarUsuario(String json) {
        try {
            UsuarioDto usuarioDto = objectMapper.readValue(json, UsuarioDto.class);
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
            usuario.setCorreoElectronico(usuarioDto.getCorreoElectronico());
            usuario.setContrasena(usuarioDto.getContrasena());

            usuarioRepository.save(usuario);
            return "El usuario se ha insertado correctamente.";
        } catch (JsonProcessingException e) {
            return "Error al insertar el usuario.";
        }
    }


}