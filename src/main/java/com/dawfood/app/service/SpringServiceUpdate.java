package com.dawfood.app.service;

import com.dawfood.app.dto.*;
import com.dawfood.app.entity.*;
import com.dawfood.app.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpringServiceUpdate {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public String actualizarCategoria(Long idCategoria, String json) {
        Categoria c1 = getCategoria(idCategoria);
        CategoriaDto edit;
        if (c1 != null) {
            if (categoriaRepository.existsById(idCategoria)) {
                try {
                    edit = objectMapper.readValue(json, CategoriaDto.class);
                    c1.setNombreCategoria(edit.getNombreCategoria());
                    c1.setNombreSubCategoria(edit.getNombreSubCategoria());
                    categoriaRepository.save(c1);
                    return "La categoria se ha editado correctamente.";
                } catch (JsonMappingException e) {
                    return "No se ha podido editar la categoria.";
                } catch (JsonProcessingException e) {
                    return "No se ha podido editar la categoria.";
                }
            } else {
                return "La categoría especificada no existe.";
            }
        } else {
            return "No se ha podido editar la categoria.";
        }
    }

    public Categoria getCategoria(Long idCategoria) {
        Optional<Categoria> opt = categoriaRepository.findById(idCategoria);
        return opt.orElse(null);
    }

    public String actualizarPedido(Long idPedido, String json) {
        Pedido p1 = getPedido(idPedido);
        PedidoDto edit;
        if (p1 != null) {
            if (pedidoRepository.existsById(idPedido)) {
                try {
                    edit = objectMapper.readValue(json, PedidoDto.class);
                    p1.setPrecioPedido(edit.getPrecioPedido());
                    pedidoRepository.save(p1);
                    return "El pedido se ha editado correctamente.";
                } catch (JsonMappingException e) {
                    return "No se ha podido editar el pedido.";
                } catch (JsonProcessingException e) {
                    return "No se ha podido editar el pedido.";
                }
            } else {
                return "La pedido especificado no existe.";
            }
        } else {
            return "No se ha podido editar el pedido.";
        }
    }

    public Pedido getPedido(Long idPedido) {
        Optional<Pedido> opt = pedidoRepository.findById(idPedido);
        return opt.orElse(null);
    }

    public String actualizarProducto(Long idProducto, String json) {
        Producto p1 = getProducto(idProducto);
        ProductoDto edit;
        if (p1 != null) {
            if (productoRepository.existsById(idProducto)) {
                try {
                    edit = objectMapper.readValue(json, ProductoDto.class);
                    p1.setDescripcion(edit.getDescripcion());
                    p1.setIvaProducto(edit.getIvaProducto());
                    p1.setNombreProducto(edit.getNombreProducto());
                    p1.setPrecioProducto(edit.getPrecioProducto());
                    p1.setStockProducto(edit.getStockProducto());

                    // Obtenemos la categoría del producto
                    CategoriaDto categoriaDto = edit.getCategoria();


                    if (categoriaDto == null) {
                        return "La categoría no puede ser nula.";
                    }

                    // Verificamos si la categoría existe en la base de datos
                    Categoria categoria = categoriaRepository.findById(categoriaDto.getIdCategoria()).orElse(null);

                    if (categoria == null) {
                        return "La categoría especificada no existe.";
                    }

                    p1.setCategoria(categoria);
                    productoRepository.save(p1);
                    return "El producto se ha editado correctamente.";
                } catch (JsonMappingException e) {
                    return "No se ha podido editar el producto.";
                } catch (JsonProcessingException e) {
                    return "No se ha podido editar el producto.";
                }
            } else {
                return "La producto especificado no existe.";
            }
        } else {
            return "No se ha podido editar el producto.";
        }
    }

    public Producto getProducto(Long idProducto) {
        Optional<Producto> opt = productoRepository.findById(idProducto);
        return opt.orElse(null);
    }

    public String actualizarUsuario(Long idUsuario, String json) {
        Usuario u1 = getUsuario(idUsuario);
        UsuarioDto edit;
        if (u1 != null) {
            if (usuarioRepository.existsById(idUsuario)) {
                try {
                    edit = objectMapper.readValue(json, UsuarioDto.class);
                    u1.setNombreUsuario(edit.getNombreUsuario());
                    u1.setCorreoElectronico(edit.getCorreoElectronico());
                    u1.setContrasena(edit.getContrasena());
                    usuarioRepository.save(u1);
                    return "El usuario se ha editado correctamente.";
                } catch (JsonMappingException e) {
                    return "No se ha podido editar el usuario.";
                } catch (JsonProcessingException e) {
                    return "No se ha podido editar el usuario.";
                }
            } else {
                return "El usuario especificado no existe.";
            }
        } else {
            return "No se ha podido editar el usuario.";
        }
    }

    public Usuario getUsuario(Long idUsuario) {
        Optional<Usuario> opt = usuarioRepository.findById(idUsuario);
        return opt.orElse(null);
    }

    public String actualizarDetallePedido(Long idPedido, Long idProducto, String json) {
        DetallePedido dp1 = getDetallePedido(idPedido, idProducto);

        DetallePedidoDto edit;
        if (dp1 != null) {
            if (detallePedidoRepository.existsById(new DetallePedidoId(idPedido, idProducto))) {
                try {
                    edit = objectMapper.readValue(json, DetallePedidoDto.class);
                    dp1.setCantidadProducto(edit.getCantidadProducto());
                    detallePedidoRepository.save(dp1);
                    return "Los detalles del pedido se han editado correctamente.";
                } catch (JsonMappingException e) {
                    return "No se han podido editar los detalles del pedido.";
                } catch (JsonProcessingException e) {
                    return "No se han podido editar los detalles del pedido.";
                }
            } else {
                return "Los detalles del pedido especificado no existen.";
            }
        } else {
            return "No se han podido editar los detalles del pedido.";
        }
    }

    public DetallePedido getDetallePedido(Long idPedido, Long idProducto) {
        Optional<DetallePedido> opt = detallePedidoRepository.findById(new DetallePedidoId(idPedido, idProducto));
        return opt.orElse(null);
    }

}