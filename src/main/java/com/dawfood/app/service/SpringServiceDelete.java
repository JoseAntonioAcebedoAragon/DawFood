package com.dawfood.app.service;

import com.dawfood.app.entity.DetallePedido;
import com.dawfood.app.entity.DetallePedidoId;
import com.dawfood.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpringServiceDelete {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public String deleteCategoria(Long idCategoria) {
        if (categoriaRepository.existsById(idCategoria)) {
            categoriaRepository.deleteById(idCategoria);
            return "La categoría se ha eliminado correctamente.";
        } else {
            return "Error al eliminar la categoría.";
        }
    }

    public String deletePedido(Long idPedido) {
        if (pedidoRepository.existsById(idPedido)) {
            pedidoRepository.deleteById(idPedido);
            return "El pedido se ha eliminado correctamente.";
        } else {
            return "Error al eliminar el pedido.";
        }
    }

    public String deleteProducto(Long idProducto) {
        if (productoRepository.existsById(idProducto)) {
            productoRepository.deleteById(idProducto);
            return "El producto se ha eliminado correctamente.";
        } else {
            return "Error al eliminar el producto.";
        }
    }

    public String deleteUsuario(Long idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
            return "El usuario se ha eliminado correctamente.";
        } else {
            return "Error al eliminar el usuario.";
        }
    }

//    public String deleteDetallePedido(Long idPedido, Long idProducto) {
//        if (detallePedidoRepository.existsById(idPedido) && detallePedidoRepository.existsById(idProducto)) {
//            detallePedidoRepository.deleteById(idPedido);
//            detallePedidoRepository.deleteById(idProducto);
//            return "El detalle del pedido se ha eliminado correctamente.";
//        } else {
//            return "Error al eliminar el detalle del pedido.";
//        }
//    }

    public String deleteDetallePedido(Long idPedido, Long idProducto) {
        // Construir el ID compuesto de DetallePedido
        DetallePedidoId detallePedidoId = new DetallePedidoId(idPedido, idProducto);

        // Verificar si existe el DetallePedido con el ID compuesto dado
        if (detallePedidoRepository.existsById(detallePedidoId)) {
            // Eliminar el DetallePedido con el ID compuesto dado
            detallePedidoRepository.deleteById(detallePedidoId);
            return "El detalle del pedido se ha eliminado correctamente.";
        } else {
            return "Error al eliminar el detalle del pedido.";
        }
    }


}
