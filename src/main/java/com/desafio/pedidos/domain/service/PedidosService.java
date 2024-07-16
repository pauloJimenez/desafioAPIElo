package com.desafio.pedidos.domain.service;

import com.desafio.pedidos.domain.DTO.PedidoDTO;
import com.desafio.pedidos.domain.entity.Pedido;

public interface PedidosService {
	Pedido salvarPedido(PedidoDTO pedido);	
	Pedido consultarPedidoPorNumeroPedido(String numeroPedido);	
}
