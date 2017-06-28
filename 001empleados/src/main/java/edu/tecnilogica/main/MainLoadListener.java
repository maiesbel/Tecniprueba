package edu.tecnilogica.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;

import edu.tecnilogica.entity.Regions;


public class MainLoadListener {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactori();
		EntityManager em = emf.createEntityManager();
		
		//COMO ACTIVAR LISTENER EVENTOS PARA HB 5
		
		SessionFactoryImpl sfi = emf.unwrap(SessionFactoryImpl.class);
		EventListenerRegistry registry = sfi.getServiceRegistry().getService(EventListenerRegistry.class);
		registry.getEventListenerGroup(EventType.LOAD).appendListener(new MyLoadListener());
		
		Session sesion = sfi.openSession();
		Transaction tx = sesion.beginTransaction();
		
		sesion.get(Regions.class, new BigDecimal(1));
		tx.commit();
		sesion.close();
		emf.close();
		

	}

}
