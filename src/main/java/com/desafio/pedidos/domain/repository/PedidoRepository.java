package com.desafio.pedidos.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.desafio.pedidos.domain.entity.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, Long> {
	Pedido findByNumeroPedido(String numeroPedido);
}
