package com.desafio.pedidos.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.pedidos.domain.DTO.MensagemKafkaDTO;
import com.desafio.pedidos.domain.DTO.PedidoDTO;
import com.desafio.pedidos.domain.entity.Pedido;
import com.desafio.pedidos.domain.enums.StatusEnum;
import com.desafio.pedidos.domain.repository.PedidoRepository;
import com.desafio.pedidos.domain.service.KafkaService;
import com.desafio.pedidos.domain.service.PedidosService;

@Service
public class PedidoServiceImpl implements PedidosService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private KafkaService kafkaService;

	@Override
	public Pedido salvarPedido(PedidoDTO pedido) {
		Pedido pedidoSalvo = pedidoRepository
				.save(Pedido.builder().numeroPedido(pedido.getNumeroPedido()).idCliente(pedido.getIdCliente())
						.produtos(pedido.getProdutos()).status(StatusEnum.AGUARDANDO_ENVIO).build());
		kafkaService.enviarMensagem(MensagemKafkaDTO.builder().numeroPedido(pedidoSalvo.getNumeroPedido()).build());
		return pedidoSalvo;
	}

	@Override
	public Pedido consultarPedidoPorNumeroPedido(String numeroPedido) {
		return pedidoRepository.findByNumeroPedido(numeroPedido);
	}

}
