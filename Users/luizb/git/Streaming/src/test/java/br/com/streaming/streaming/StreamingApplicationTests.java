package br.com.streaming.streaming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.streaming.streaming.entity.Movie;
import br.com.streaming.streaming.entity.MovieType;
import br.com.streaming.streaming.repository.MovieRepository;

@SpringBootTest
class StreamingApplicationTests {
	@Autowired
	private MovieRepository movieRepository;

	@Test
	public void createTest() {
		Movie movie = new Movie();
		String name = "matrix";
		MovieType type = MovieType.Movie;
		Integer year = 2020;
		String language = "PT";
		String list = "aaaaaa";
		String synopsis = "bbbbbbb";
		String trailer = "ccccccc";
		String banner = "img.jpg";
		String gender = "romance";
		
		movie.setMovieName(name);
		movie.setMovieType(type);
		movie.setMovieYear(year);
		movie.setLanguage(language);
		movie.setList(list);
		movie.setSynopsis(synopsis);
		movie.setTrailer(trailer);
		movie.setBanner(banner);
		movie.setGender(gender);
		
		Movie moviesaved = movieRepository.save(movie);
		
		assertEquals(moviesaved.getMovieName(), name);
	}
	@Test
	public void getAllTest() {
		List<Movie> list = movieRepository.findAll();
		
		assertNotNull(list);
	}
	@Test
	public void findByIdTest() {
	    Movie movie = new Movie();
	    movie.setMovieName("Inception");
	    movie.setMovieType(MovieType.Movie);
	    movie.setMovieYear(2010);
	    movie.setLanguage("EN");
	    movie.setList("top10");
	    movie.setSynopsis("A thief who steals corporate secrets...");
	    movie.setTrailer("trailer_link");
	    movie.setBanner("banner.jpg");
	    movie.setGender("Sci-Fi");

	    Movie savedMovie = movieRepository.save(movie);

	    Optional<Movie> foundMovie = movieRepository.findById(savedMovie.getId());

	    assertTrue(foundMovie.isPresent());
	    assertEquals(savedMovie.getMovieName(), foundMovie.get().getMovieName());
	}
	@Test
	public void updateTest() {
	    Movie movie = new Movie();
	    movie.setMovieName("Avatar");
	    movie.setMovieType(MovieType.Movie);
	    movie.setMovieYear(2009);
	    movie.setLanguage("EN");
	    movie.setList("top10");
	    movie.setSynopsis("A paraplegic Marine dispatched to the moon Pandora...");
	    movie.setTrailer("trailer_link");
	    movie.setBanner("banner.jpg");
	    movie.setGender("Action");

	    Movie savedMovie = movieRepository.save(movie);

	    savedMovie.setMovieName("Avatar: The Last Airbender");
	    savedMovie.setMovieYear(2010);
	    Movie updatedMovie = movieRepository.save(savedMovie);

	    assertEquals(updatedMovie.getMovieName(), "Avatar: The Last Airbender");
	    assertEquals(updatedMovie.getMovieYear(), 2010);
	}
	@Test
	public void deleteTest() {
	    Movie movie = new Movie();
	    movie.setMovieName("The Matrix");
	    movie.setMovieType(MovieType.Movie);
	    movie.setMovieYear(1999);
	    movie.setLanguage("EN");
	    movie.setList("top10");
	    movie.setSynopsis("A computer hacker learns from mysterious rebels...");
	    movie.setTrailer("trailer_link");
	    movie.setBanner("banner.jpg");
	    movie.setGender("Sci-Fi");

	    Movie savedMovie = movieRepository.save(movie);

	    movieRepository.deleteById(savedMovie.getId());

	    Optional<Movie> deletedMovie = movieRepository.findById(savedMovie.getId());

	    assertFalse(deletedMovie.isPresent());
	}
	

}
