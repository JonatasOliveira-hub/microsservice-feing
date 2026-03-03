package br.jonatas.hub.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jonatas.hub.enviroment.InstanceInformationService;
import br.jonatas.hub.model.Exchange;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

	@Autowired
	private InstanceInformationService informationService;
	
	
	@GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Exchange getExchange(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {
		return new Exchange(1L, from, to, "PORT" + informationService.retrievePort(), BigDecimal.ONE, BigDecimal.ONE);
	}
}
