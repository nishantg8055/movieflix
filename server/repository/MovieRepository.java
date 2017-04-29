package io.egen.movieflix.repository;

import io.egen.movieflix.entity.Movie;
import java.util.*;

public interface MovieRepository {

	public List<Movie> findAll();
	
	public List<Movie> findAllByType(String type);
	
	public Movie findByTitle(String title);
	
	public List<Movie> findAllByYear(String year);
	
	public List<Movie> findAllByGenre(String genre);

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie movie);
}
