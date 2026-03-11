package br.jonatas.hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jonatas.hub.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	//Exchange findByFromAndTo(String from, String to);
}
