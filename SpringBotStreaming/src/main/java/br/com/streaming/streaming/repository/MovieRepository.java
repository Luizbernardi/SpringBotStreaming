package br.com.streaming.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.streaming.streaming.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
}
