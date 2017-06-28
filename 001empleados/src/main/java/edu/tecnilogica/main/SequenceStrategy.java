package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.RegistroSeq;

public class SequenceStrategy {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		try {
			
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			RegistroSeq rg = new RegistroSeq();
			RegistroSeq rg1 = new RegistroSeq();
			RegistroSeq rg2 = new RegistroSeq();
			
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
