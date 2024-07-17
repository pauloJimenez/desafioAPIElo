package com.desafio.pedidos.adapter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.desafio.pedidos.domain.entity.Pedido;
import com.desafio.pedidos.domain.enums.StatusEnum;
import com.desafio.pedidos.domain.service.PedidosService;

public class PedidoControllerTest {

	@InjectMocks
	private PedidoController pedidoController;

	@Mock
	private PedidosService pedidoService;

	private Pedido mockPedidoResponse;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		ReflectionTestUtils.setField(pedidoController, "pedidoService", pedidoService);
		mockPedidoResponse = Pedido.builder().id("1").numeroPedido("123").idCliente(1)
				.produtos(new String[] { "produto1", "produto2" }).status(StatusEnum.AGUARDANDO_ENVIO).build();
	}

	@Test
	void criarPedido() {		
		when(pedidoService.salvarPedido(Mockito.any())).thenReturn(mockPedidoResponse);
		ResponseEntity<Pedido> responseEntityPedido = pedidoController.criarPedido(Mockito.any());
		assertEquals(responseEntityPedido.getStatusCode(), HttpStatus.CREATED);
		assertEquals(responseEntityPedido.getBody().getNumeroPedido(), mockPedidoResponse.getNumeroPedido());
	}
	
	@Test
	void consultarPedido() {
		String numeroPedido ="123";		
		when(pedidoService.consultarPedidoPorNumeroPedido(numeroPedido)).thenReturn(mockPedidoResponse);
		ResponseEntity<Pedido> responseEntityPedido = pedidoController.consultarPedido(numeroPedido);
		assertEquals(responseEntityPedido.getStatusCode(), HttpStatus.OK);
		assertEquals(responseEntityPedido.getBody().getNumeroPedido(), numeroPedido);
	}
	
}
