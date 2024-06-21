package br.com.streaming.streaming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

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
	

}
