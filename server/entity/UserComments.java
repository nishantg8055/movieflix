package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "UserComments.findCommentsForMovie", query = "SELECT u FROM UserComments u where u.movie.id = :pMovieId")
})
public class UserComments {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="userId", referencedColumnName="id")
	private User user;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="MovieId", referencedColumnName="id")
	private Movie movie;
	
	private String comments;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the Movie
	 */
	public Movie getMovie() {
		return movie;
	}
	/**
	 * @param Movie the Movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserComments [id=" + id + ", user=" + user + ", Movie=" + movie + ", comments=" + comments + "]";
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
