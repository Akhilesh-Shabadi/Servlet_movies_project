package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String language;
	private String genre;
	private double rating;

	@Lob
	private byte[] img;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getLanguage() {
//		return language;
//	}
//
//	public void setLanguage(String language) {
//		this.language = language;
//	}
//
//	public String getGenre() {
//		return genre;
//	}
//
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//
//	public double getRating() {
//		return rating;
//	}
//
//	public void setRating(double rating) {
//		this.rating = rating;
//	}
//
//	public byte[] getImg() {
//		return img;
//	}
//
//	public void setImg(byte[] img) {
//		this.img = img;
//	}
}
