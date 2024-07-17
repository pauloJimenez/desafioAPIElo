package com.desafio.pedidos.domain.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PedidoDTO {
	private String numeroPedido;	
	private int idCliente;	
	private String[] produtos;	
	private String status;
}
