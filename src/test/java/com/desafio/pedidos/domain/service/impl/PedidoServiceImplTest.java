package com.desafio.pedidos.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.desafio.pedidos.domain.DTO.PedidoDTO;
import com.desafio.pedidos.domain.entity.Pedido;
import com.desafio.pedidos.domain.enums.StatusEnum;
import com.desafio.pedidos.domain.repository.PedidoRepository;
import com.desafio.pedidos.domain.service.KafkaService;

public class PedidoServiceImplTest {

	@InjectMocks
	private PedidoServiceImpl pedidoServiceImpl;

	@Mock
	private PedidoRepository pedidoRepository;

	@Mock
	private KafkaService kafkaService;

	private Pedido mockPedidoEntidade;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		ReflectionTestUtils.setField(pedidoServiceImpl, "pedidoRepository", pedidoRepository);
		ReflectionTestUtils.setField(pedidoServiceImpl, "kafkaService", kafkaService);
		mockPedidoEntidade = Pedido.builder().id("1").numeroPedido("123").idCliente(1)
				.produtos(new String[] { "produto1", "produto2" }).status(StatusEnum.AGUARDANDO_ENVIO).build();
	}

	@Test
	void salvarPedido() {

		PedidoDTO pedidoDto = PedidoDTO.builder().numeroPedido("123").idCliente(1).produtos(new String[] { "produto1", "produto2" })
				.build();

		when(pedidoRepository.save(Mockito.any())).thenReturn(mockPedidoEntidade);
		doNothing().when(kafkaService).enviarMensagem(Mockito.any());
		Pedido pedido = pedidoServiceImpl.salvarPedido(pedidoDto);
		assertEquals(pedido.getNumeroPedido(), "123");
		assertEquals(pedido.getStatus(), StatusEnum.AGUARDANDO_ENVIO);
	}
	
	@Test
	void consultarPedidoPorNumeroPedido() {
		when(pedidoRepository.findByNumeroPedido(Mockito.anyString())).thenReturn(mockPedidoEntidade);
		Pedido pedido = pedidoServiceImpl.consultarPedidoPorNumeroPedido(Mockito.anyString());
		assertEquals(pedido.getNumeroPedido(), "123");		
	}
}
