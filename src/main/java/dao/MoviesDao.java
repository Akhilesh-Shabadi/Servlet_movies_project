package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Movies;

public class MoviesDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("akhil");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void saveMovie(Movies movies) {
		transaction.begin();
		manager.persist(movies);
		transaction.commit();
	}

//	public Movies fetchall() {
//		List<Movies> movies=manager.createQuery("select s from Movies s").getResultList();
//		for(Movies movies2:movies) {
//			System.out.println(movies2);
//			return movies2;
//		}
//		return (Movies) movies;
//	}

	public List<Movies> fetchall() {
		return manager.createQuery("select s from Movies s").getResultList();
	}

	public List<Movies> fetch(String name) {
		return manager.createQuery("select s from Movies s where name = ?1").setParameter(1, name).getResultList();
	}

	public List<Movies> rating(double rating) {
		return manager.createQuery("select s from Movies s where rating >= ?1").setParameter(1, rating).getResultList();
	}

	public List<Movies> id(int id) {
		return manager.createQuery("select s from Movies s where id = ?1").setParameter(1, id).getResultList();
	}

	public List<Movies> lang(String lang) {
		return manager.createQuery("select s from Movies s where language = ?1").setParameter(1, lang).getResultList();
	}

	public List<Movies> genre(String genre) {
		return manager.createQuery("select s from Movies s where genre = ?1").setParameter(1, genre).getResultList();
	}

	public void deletemovie(int id) {
		transaction.begin();
		manager.remove(manager.find(Movies.class, id));
		transaction.commit();
	}
}
