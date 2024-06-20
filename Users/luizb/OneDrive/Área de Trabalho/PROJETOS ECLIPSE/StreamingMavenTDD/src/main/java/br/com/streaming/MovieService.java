package br.com.streaming;

import java.util.List;

public interface MovieService {
	public void add(Movie p);
	public void edit(Movie p);
	public List<Movie> list();
	public void delete(long idMovie);
	public Movie findById(long idMovie);
	public Movie findMovieByMovieName(String name);
	public Movie findMovieByMovieNameandMovieYear(String name, Integer year);
	public List<Movie> findByGender(String gender);
	public List<Movie> findByMovieType(MovieType movieType);
}
