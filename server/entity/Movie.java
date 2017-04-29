package io.egen.movieflix.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear"),
		@NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre=:pGenre"),
		@NamedQuery(name = "Movie.findTopRatedMovie", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbRating DESC")
})

public class Movie {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	@Column(unique = true)
	private String title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getRated() {
	return rated;
}
public void setRated(String rated) {
	this.rated = rated;
}
public String getReleased() {
	return released;
}
public void setReleased(String released) {
	this.released = released;
}
public String getRuntime() {
	return runtime;
}
public void setRuntime(String runtime) {
	this.runtime = runtime;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getActors() {
	return actors;
}
public void setActors(String actors) {
	this.actors = actors;
}
public String getPlot() {
	return plot;
}
public void setPlot(String plot) {
	this.plot = plot;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getAwards() {
	return awards;
}
public void setAwards(String awards) {
	this.awards = awards;
}
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public int getMetaScore() {
	return metaScore;
}
public void setMetaScore(int metaScore) {
	this.metaScore = metaScore;
}
public int getImdbRating() {
	return imdbRating;
}
public void setImdbRating(int imdbRating) {
	this.imdbRating = imdbRating;
}
public int getImdbVotes() {
	return imdbVotes;
}
public void setImdbVotes(int imdbVotes) {
	this.imdbVotes = imdbVotes;
}
public String getImdbId() {
	return imdbId;
}
public void setImdbId(String imdbId) {
	this.imdbId = imdbId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
private String rated;
private String released;
private String runtime;
private String genre;
private String director;
private String writer;
private String actors;
private String plot;
private String language;
private String country;
private String awards;
private String poster;
private int metaScore;
private int imdbRating;
private int imdbVotes;
private String imdbId;
private String type;
}
