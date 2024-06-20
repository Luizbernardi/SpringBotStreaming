package br.com.streaming;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StreamingTest {
	private MovieService movieRepository;

	@Before
	public void setup() {
		movieRepository = new MovieServiceImp();
	}
	@Test 
	public void shouldAddMovies() throws Exception {
		Movie movie = new Movie(1,"era do gelo",MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie);
		Movie foundMovie = movieRepository.findById(1);
		assertNotNull(foundMovie);
		assertEquals("era do gelo", foundMovie.getMovieName());
	}
	@Test
	public void shouldEditMovies() throws Exception {
		Movie movie = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie);

		Movie updateMovie = new Movie(1, "era do gelo 2", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.edit(updateMovie);

		Movie foundMovie	= movieRepository.findById(1);
		assertNotNull(foundMovie);
		assertEquals("era do gelo 2", foundMovie.getMovieName());
	}
	@Test
	public void shouldListMovies() throws Exception {
		Movie movie1 = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		Movie movie2 = new Movie(2, "era do gelo 2", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie1);
		movieRepository.add(movie2);
		List<Movie> movies = movieRepository.list();
		assertEquals(2, movies.size());
	}
	@Test
	public void shouldDeleteMovies() throws Exception {
		Movie movie = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie);
		movieRepository.delete(1);
		Movie foundMovie = movieRepository.findById(1);
		assertNull(foundMovie);
	}
	@Test
	public void shouldFindByIdMovies() throws Exception {
		Movie movie = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie);
		Movie foundMovie = movieRepository.findById(1);
		assertNotNull(foundMovie);
		assertEquals("era do gelo", foundMovie.getMovieName());

	}
	@Test
	public void shouldFindByNameMovies() throws Exception {
		Movie movie = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie);
		Movie foundMovie = movieRepository.findMovieByMovieName("era do gelo");
		assertNotNull(foundMovie);
		assertEquals("era do gelo", foundMovie.getMovieName());

	}
	@Test
	public void shouldFindByNameAndYearMovies() throws Exception {
		Movie movie = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie);
		Movie foundMovie = movieRepository.findMovieByMovieNameandMovieYear("era do gelo", 2014);
		assertNotNull(foundMovie);
		assertEquals("era do gelo", foundMovie.getMovieName());
		assertEquals(2014, foundMovie.getMovieYear().intValue());

	}
	@Test
	public void shouldFindByGenderMovies() throws Exception {
		Movie movie1 = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		Movie movie2 = new Movie(2, "era do gelo 2", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie1);
		movieRepository.add(movie2);
		List<Movie> animationsMovies = movieRepository.findByGender("animation");
		assertEquals(2, animationsMovies.size());
		assertEquals("era do gelo", animationsMovies.get(0).getMovieName());

	}
	@Test
	public void shouldFindByTypeMovies() throws Exception {
		Movie movie1 = new Movie(1, "era do gelo", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		Movie movie2 = new Movie(2, "era do gelo 2", MovieType.COMEDY, 2014, "English", "list1", "comedy for children", "Trailer_url", "Banner_url", "animation");
		movieRepository.add(movie1);
		movieRepository.add(movie2);
		List<Movie> comedyMovies = movieRepository.findByMovieType(MovieType.COMEDY);
		assertEquals(2, comedyMovies.size());
		assertEquals("era do gelo", comedyMovies.get(0).getMovieName());

	}


}
