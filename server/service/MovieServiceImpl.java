package io.egen.movieflix.service;
import io.egen.movieflix.exception.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movie;

import io.egen.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String movId) {
		Movie mov = repository.findOne(movId);
		if (mov == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return mov;
	}

	@Transactional
	@Override
	public Movie create(Movie mov) {
	Movie existing = repository.findByTitle(mov.getTitle());
	if (existing != null) {
		throw new MovieAlreadyExistException("Movie already exists with this title");
	}
		return repository.create(mov);
	}

	@Transactional
	@Override
	public Movie update(String movId, Movie mov) {
		Movie existing = repository.findOne(movId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return repository.update(mov);
	}

	@Transactional
	@Override
	public void delete(String movId) {
		Movie existing = repository.findOne(movId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<Movie> findAllByType(String type) {
		
		return repository.findAllByType(type);
	}

	@Override
	public Movie findByTitle(String title) {
		// TODO Auto-generated method stub
		return repository.findByTitle(title);
	}

	@Override
	public List<Movie> findAllByYear(String year) {
		
		return repository.findAllByYear(year);
	}

	@Override
	public List<Movie> findAllByGenre(String genre) {
		
		return repository.findAllByGenre(genre);
	}
}
