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
import br.jonatas.hub.repository.ExchangeRepository;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

	@Autowired
	private InstanceInformationService informationService;
	
	@Autowired
	private ExchangeRepository repository;
	
	@GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Exchange getExchange(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {
		
		Exchange exchange =  repository.findByFromAndTo(from, to);
		
		if (exchange == null) throw new RuntimeException("Curency Unsupported!!!");
		final BigDecimal conversionFactor = exchange.getConversionFactory();
		final BigDecimal convertedValue = conversionFactor.multiply(amount);
		exchange.setConvertedValue(convertedValue);
		exchange.setEnviroment("PORT" + informationService.retrievePort());
		return exchange;
		
	}
	
	
	//Retorno Mockado - return new Exchange(1L, from, to, "PORT" + informationService.retrievePort(), BigDecimal.ONE, BigDecimal.ONE);
}
