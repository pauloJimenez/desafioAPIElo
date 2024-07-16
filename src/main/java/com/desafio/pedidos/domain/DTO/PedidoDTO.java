package com.desafio.pedidos.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PedidoDTO {
	private String numeroPedido;	
	private int idCliente;	
	private String[] produtos;	
	private String status;
}
