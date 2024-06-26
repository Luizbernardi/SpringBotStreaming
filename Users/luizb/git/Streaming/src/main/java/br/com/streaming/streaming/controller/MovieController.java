package br.com.streaming.streaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.streaming.streaming.entity.Movie;
import br.com.streaming.streaming.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/movies")
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}
	@PostMapping("/movies")
	public Movie create(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}
	@PatchMapping("/movies/{id}")
	public void updatePatch(@PathVariable(value ="id") long movieId,@RequestBody Movie movieDetails) {
		Movie movie = movieRepository.findById(movieId).get();
		movie.setMovieName(movieDetails.getMovieName());
		movie.setMovieType(movieDetails.getMovieType());
		movie.setMovieYear(movieDetails.getMovieYear());
		movie.setLanguage(movieDetails.getLanguage());
		movie.setList(movieDetails.getList());
		movie.setSynopsis(movieDetails.getSynopsis());
		movie.setTrailer(movieDetails.getTrailer());
		movie.setBanner(movieDetails.getBanner());
		movie.setGender(movieDetails.getGender());

		movieRepository.save(movie);
	}

	@PutMapping("/movies/{id}")
	public void update(@PathVariable(value ="id") long movieId,@RequestBody Movie movieDetails) {
		movieRepository.save(movieDetails);
	}

	@GetMapping("/movies/{id}")
	public Movie getById(@PathVariable(value ="id") long movieId) {
		return movieRepository.findById(movieId).get();
	}

	@DeleteMapping("/movies/{id}")
	public void delete(@PathVariable(value = "id") long movieId) {
		movieRepository.deleteById(movieId);
	}
}
