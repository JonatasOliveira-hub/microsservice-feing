package br.jonatas.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jonatas.hub.dto.ExchangeDto;
import br.jonatas.hub.enviroment.InstanceInformationService;
import br.jonatas.hub.model.Book;
import br.jonatas.hub.proxy.ExchangeProxy;
import br.jonatas.hub.repository.BookRepository;

@RestController
@RequestMapping("book-service")
public class BookController {

	@Autowired
	private InstanceInformationService service;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private ExchangeProxy proxy;

	
	@GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book findBook(@PathVariable Long id, @PathVariable String currency) {
		final String port = service.retrievePort();
		
		var book = repository.findById(id).orElseThrow();
		book.setEnviroment(port + "FEING");
		book.setCurrency(currency);
		
		final ExchangeDto exchangeDto = proxy.getExchange(book.getPrice(), "USD", currency);
		book.setPrice(exchangeDto.getConvertedValue());
		
		return book;
		//return new Book(1L, "Nigel Poulton", "Docker Deep Dive", LocalDateTime.now(), 15.8, "BRL", port);
	}
	
	/*
	 * @GetMapping(value = "/{id}/{currency}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public Book findBook(@PathVariable Long
	 * id, @PathVariable String currency) { final String port =
	 * service.retrievePort();
	 * 
	 * var book = repository.findById(id).orElseThrow(); book.setEnviroment(port);
	 * book.setCurrency(currency); return book; //return new Book(1L,
	 * "Nigel Poulton", "Docker Deep Dive", LocalDateTime.now(), 15.8, "BRL", port);
	 * }
	 */
}
