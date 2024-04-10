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
}
