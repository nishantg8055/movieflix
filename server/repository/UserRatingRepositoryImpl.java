package io.egen.movieflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.UserRating;

@Repository
public class UserRatingRepositoryImpl implements UserRatingRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Double findRatingsForMovie(String movId) {
		TypedQuery<Double> query = em.createNamedQuery("UserRating.fingAvg", Double.class);
		query.setParameter("pMovieId", movId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public UserRating create(UserRating userRating) {
		em.persist(userRating);
		return userRating;
	}
	
	
	

}