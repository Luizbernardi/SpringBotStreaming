package br.com.streaming;

public class Movie {
	private long id;
	private String movieName;
	private MovieType movieType;
	private Integer movieYear;
	private String language;
	private String list;
	private String synopsis;
	private String trailer;
	private String banner;
	private String gender;

	public Movie(long id, String movieName, MovieType movieType, Integer movieYear, String language, String list,
			String synopsis, String trailer, String banner, String gender) {
		this.id = id;
		this.movieName = movieName;
		this.movieType = movieType;
		this.movieYear = movieYear;
		this.language = language;
		this.list = list;
		this.synopsis = synopsis;
		this.trailer = trailer;
		this.banner = banner;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public Integer getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(Integer movieYear) {
		this.movieYear = movieYear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}




}
