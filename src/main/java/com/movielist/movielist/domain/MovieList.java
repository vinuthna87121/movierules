package com.movielist.movielist.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getters,setters.equla,hashcode,tostring
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MovieList {
	
	
	@Override
	public String toString() {
		return "MovieList [Id=" + Id + ", Name=" + name + ", Genre=" + genre + ", Rating=" + rating + ", ticketPrice="
				+ ticketPrice + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(genre, Id, name, rating, ticketPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieList other = (MovieList) obj;
		return Objects.equals(genre, other.genre) && Objects.equals(Id, other.Id) && Objects.equals(name, other.name)
				&& Objects.equals(rating, other.rating) && Objects.equals(ticketPrice, other.ticketPrice);
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	 @Column(nullable = false)
	private String name;
	 @Column(nullable = false)
	private String genre;
	 @Column(nullable = false)
	private Float rating;
	 @Column(nullable = false)
	private Integer ticketPrice;
	

}
