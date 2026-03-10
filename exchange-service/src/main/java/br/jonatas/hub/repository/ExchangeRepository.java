package br.jonatas.hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jonatas.hub.model.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

	Exchange findByFromAndTo(String from, String to);
}
