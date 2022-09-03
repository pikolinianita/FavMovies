package pl.lcc.web2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.lcc.web2.entities.UserEntity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nauczyciel
 */
@WebListener
public class StupidListener implements ServletContextListener {

    // @PersistenceContext 
    // EntityManager em;
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        var factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        try ( Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(new UserEntity(1L, "kiko", "freeko"));
            tx.commit();
        }
        
        try ( Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
          //  var itIs = session.byId(UserEntity.class).loadOptional(Long.valueOf(1));
          //  var itIsNot = session.byId(UserEntity.class).loadOptional(Long.valueOf(2));
          var itIs = session.byId(UserEntity.class).load(1L);
            System.out.println(itIs);
          //  System.out.println(itIs);
           // System.out.println(itIsNot);
            tx.commit();
        }

    }
}
