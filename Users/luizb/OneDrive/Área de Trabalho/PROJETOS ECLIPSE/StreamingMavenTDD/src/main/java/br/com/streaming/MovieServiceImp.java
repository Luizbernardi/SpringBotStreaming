package br.com.streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImp implements MovieService {
	private List<Movie> movies = new ArrayList<>();
	@Override
	public void add(Movie p) {
		movies.add(p);
	}
	@Override
	public void edit(Movie p) {
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getId() == p.getId()) {
				movies.set(i, p);
				break;
			}
		}
	}
	@Override
	public List<Movie> list() {
		return new ArrayList<>(movies);
	}

	@Override
	public void delete(long idMovie) {
		movies.removeIf(movie -> movie.getId() == idMovie);
	}

	@Override
	public Movie findById(long idMovie) {
		return movies.stream().filter(movie -> movie.getId() == idMovie).findFirst().orElse(null);
	}

	@Override
	public Movie findMovieByMovieName(String name) {
		return movies.stream().filter(movie -> movie.getMovieName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	@Override
	public Movie findMovieByMovieNameandMovieYear(String name, Integer year) {
		return movies.stream().filter(movie -> movie.getMovieName().equalsIgnoreCase(name) && movie.getMovieYear().equals(year)).findFirst().orElse(null);
	}

	@Override
	public List<Movie> findByGender(String gender) {
		return movies.stream().filter(movie -> movie.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
	}

	@Override
	public List<Movie> findByMovieType(MovieType movieType) {
		return movies.stream().filter(movie -> movie.getMovieType() == movieType).collect(Collectors.toList());
	}

}
