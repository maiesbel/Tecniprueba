package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registro;

public class InterceptorMain {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		Session sesion = sf.withOptions().interceptor(new MyInterceptor()).openSession();
		
		Transaction tx = sesion.beginTransaction();
		
		Registro registro = new Registro();
		sesion.save(registro);
		tx.commit();
		sesion.close();
		sf.close();
		
		
	}

}
