package com.desafio.pedidos.domain.entity;

//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.desafio.pedidos.domain.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document(collection = "Pedido")
@Data
@AllArgsConstructor
@Builder
public class Pedido {
	@Field("NR_PEDIDO")
	private String numeroPedido;
	@Field("ID_CLIENTE")
	private int idCliente;
	@Field("PRODUTOS")
	private String[] produtos;
	@Field("STATUS")
	private StatusEnum status;
}
