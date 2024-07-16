package com.desafio.pedidos.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MensagemKafkaDTO {
	private String numeroPedido;
}
