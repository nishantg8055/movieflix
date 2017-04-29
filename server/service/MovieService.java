package io.egen.movieflix.service;
import java.util.List;

import io.egen.movieflix.entity.Movie;

public interface MovieService {
public List<Movie> findAll();
	
	public List<Movie> findAllByType(String type);
	
	public Movie findByTitle(String title);
	
	public List<Movie> findAllByYear(String year);
	
	public List<Movie> findAllByGenre(String genre);

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(String id, Movie movie);

	public void delete(String id);

}
