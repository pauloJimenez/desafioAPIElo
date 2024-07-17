package com.desafio.pedidos.domain.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MensagemKafkaDTO {
	private String numeroPedido;
}
