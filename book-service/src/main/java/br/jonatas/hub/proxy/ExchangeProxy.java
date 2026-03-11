package br.jonatas.hub.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.jonatas.hub.dto.ExchangeDto;

@FeignClient(name = "exchange-service", url = "localhost:8000")
public interface ExchangeProxy {
	
	@GetMapping(value = "exchange-service/{amount}/{from}/{to}")
	public ExchangeDto getExchange(@PathVariable Double amount, @PathVariable String from, @PathVariable String to);
		

}
