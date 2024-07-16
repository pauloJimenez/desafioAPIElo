package com.desafio.pedidos.domain.service;

import com.desafio.pedidos.domain.DTO.MensagemKafkaDTO;

public interface KafkaService {
	void enviarMensagem(MensagemKafkaDTO mensagemKafkaDTO);	
}
