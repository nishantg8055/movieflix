package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.UserComments;

@Repository
public class UserCommentsRepositoryImpl implements UserCommentsRepository{
   
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserComments> findCommentsForMovie(String movId) {
		TypedQuery<UserComments> query = em.createNamedQuery("UserComments.findCommentsForMovie", UserComments.class);
		query.setParameter("pMovieId", movId);
		return query.getResultList();
	}

	
	@Override
	public UserComments create(UserComments userComments) {
		em.persist(userComments);
		return userComments;
	}

}
