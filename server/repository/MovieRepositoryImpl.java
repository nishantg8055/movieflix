package io.egen.movieflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Movie;
import java.util.*;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	
	@Override
	public List<Movie> findAllByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> list = query.getResultList();
		if(list!=null && list.size() == 1){
			return list.get(0);
		}
		return null;
	}

	
	@Override
	public List<Movie> findAllByYear(String year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	
	@Override
	public List<Movie> findAllByGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenre", Movie.class);
		query.setParameter("pGenre", genre);
		return query.getResultList();
	}

	
	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	
	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	
	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	
	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

}