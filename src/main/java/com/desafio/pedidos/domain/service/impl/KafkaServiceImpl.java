package com.desafio.pedidos.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.desafio.pedidos.domain.DTO.MensagemKafkaDTO;
import com.desafio.pedidos.domain.service.KafkaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaServiceImpl implements KafkaService {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	private Environment environment;

	@Override
	public void enviarMensagem(MensagemKafkaDTO mensagemKafkaDTO) {
		kafkaTemplate.send(environment.getProperty("kafka.topic.pedidos"), mensagemKafkaDTO);
	}
	
}
