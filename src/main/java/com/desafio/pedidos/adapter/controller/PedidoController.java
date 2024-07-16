package com.desafio.pedidos.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.pedidos.domain.DTO.PedidoDTO;
import com.desafio.pedidos.domain.entity.Pedido;
import com.desafio.pedidos.domain.service.PedidosService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {

	@Autowired
	private PedidosService pedidoService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedido) {
		return new ResponseEntity<Pedido>(pedidoService.salvarPedido(pedido), null, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Pedido> consultarPedido(@PathVariable String numeroPedido) {
		return new ResponseEntity<Pedido>(pedidoService.consultarPedidoPorNumeroPedido(numeroPedido), null,
				HttpStatus.OK);
	}

}
