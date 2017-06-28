package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registro;

public class UUIDStrategy {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		try {
			
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			Registro rg = new Registro();
			Registro rg1 = new Registro();
			Registro rg2 = new Registro();
			
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
