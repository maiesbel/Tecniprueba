package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;

public class MainHibernate1 {
	
	public static void main(String[] args) {
		
		SessionFactory sf = null;
		
		try{
			
			sf = HibernateFactory.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			
			try{//"Transaccion"
				
				tx = session.beginTransaction();
				Regions rg = session.get(Regions.class, new BigDecimal(1));
				System.out.println("Regi�n le�da = " + rg.getRegionName());
				System.out.println("Regi�n id = " + rg.getRegionId());
				tx.commit();
				
			}catch (Exception e) {
				
				tx.rollback();
				e.printStackTrace();
			}finally {
				session.close();
			}
			
		}catch (Throwable t) {
			t.printStackTrace();
			
		}finally { //libero
			sf.close();
		}
	
		
		
	}

}
