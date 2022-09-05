/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.services;

import pl.lcc.web2.services.annotations.PreferredDB;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.lcc.web2.entities.MovieEntity;
import pl.lcc.web2.entities.UserEntity;
import pl.lcc.web2.views.Movie;

/**
 *
 * @author Nauczyciel
 */
@Singleton
//@NotPreferred
@PreferredDB
public class HibernateDbWithH2 implements MovieDAO, Serializable {

    private org.hibernate.SessionFactory factory;

    @PostConstruct
    void init() {
        System.out.println("--- My Hibernate Post Construct");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {
            factory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Error in buildind session factory!!!!");

        }
    }

    @PreDestroy
    void closeStuff() {
        System.out.println("--- My Hibernate Pre Destroy");
        factory.close();
    }

    @Override
    public MovieDAO addMovie(String user, Movie m) {
        try ( Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            var userEntity = findUserByName(session, user);
            var movieEntity = findMovieByMovie(session, m);

            userEntity.addMovie(movieEntity);

            session.persist(userEntity);
            tx.commit();
        }
        return this;
    }

    @Override
    public boolean checkUser(String user, String password) {
        try ( Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            var userEntity = findUserByName(session, user);
            if (userEntity == null) {
                tx.commit();
                return false;
            } else {
                var result = userEntity.getPassword().equals(password);
                tx.commit();
                return result;
            }
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public String count(String user) {

        try ( Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            String hql = "select count(M) from MovieEntity M LEFT JOIN M.users users WHERE users.name = :user_name";
            var query = session.createQuery(hql, Long.class);
            query.setParameter("user_name", user);
            var result = query.uniqueResultOptional().orElse(Long.MIN_VALUE);

            tx.commit();
            return String.valueOf(result);
        }

    }

    @Override
    public MovieDAO createUser(String user, String password) {
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            if (session.bySimpleNaturalId(UserEntity.class).loadOptional(user).isEmpty()) {
                var entity = new UserEntity(null, user, password);
                session.persist(entity);
            } else {
                System.out.println("User Already Exist!");
            }
            tx.commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return this;
    }

    @Override
    public Set<Movie> getMovies(String user) {
       
        try ( Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            var userEntity = findUserByName(session, user);           
            var result = userEntity.getMovies().stream().map(MovieEntity::toMovie).collect(Collectors.toSet());

            tx.commit();
            return result;
        }
    }

    @Override
    public Set<Movie> getTop(int n) {
        try ( Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            String hql = "select M from MovieEntity M LEFT JOIN M.users users GROUP BY M.id ORDER BY count(users) DESC";
            var query = session
                    .createQuery(hql, MovieEntity.class)
                    .setMaxResults(n);
            var resultList = query.list();            
            var result = resultList.stream().map(MovieEntity::toMovie).collect(Collectors.toSet());

            tx.commit();            
            return result;
        }
    }

    private UserEntity findUserByName(final Session session, String user) {
         return session.bySimpleNaturalId(UserEntity.class).load(user);
     
    }

    private MovieEntity findMovieByMovie(final Session session, Movie m) {
        String hql = "select M from MovieEntity M where M.title = :title AND M.year = :year";
        var query = session.createQuery(hql, MovieEntity.class);
        query
                .setParameter("title", m.getTitle())
                .setParameter("year", m.getYear());

        return query.uniqueResultOptional()
                .orElse(new MovieEntity(m));
    }

}
