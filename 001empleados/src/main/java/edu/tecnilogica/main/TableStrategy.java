package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registrotable;

public class TableStrategy {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		try {
			
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			Registrotable rg = new Registrotable();
			Registrotable rg1 = new Registrotable();
			Registrotable rg2 = new Registrotable();
			
			session.save(rg);
			session.save(rg1);
			session.save(rg2);
			
			tx.commit();
			session.close();
			sf.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
