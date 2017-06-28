package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Regions;

public class MainHibernate2 {
	
	public static void main(String[] args) {
		
		SessionFactory sf = null;
		
		try{
			
			sf = HibernateFactory.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			Regions rg = new Regions();// rg es TRANSIENT no existe
			
			try{//"Transaccion"
				
				
				rg.setRegionId(new BigDecimal(33));
				rg.setRegionName("Chiquitistan");
				
				tx = session.beginTransaction();
				//Regions rg = session.get(Regions.class, new BigDecimal(1));
				
				session.save(rg); //Guardo y RG pasa a Persisten
				rg.setRegionName("Azkoitia");
				System.out.println("Región leída = " + rg.getRegionName());
				System.out.println("Región id = " + rg.getRegionId());
				
				tx.commit();
				
			}catch (Exception e) {
				
				tx.rollback();
				e.printStackTrace();
			}finally {
				session.close();
			}
			
			//rg.setRegionName("Madrid");//finally kanpun daonez errorie emateu 
			
		}catch (Throwable t) {
			t.printStackTrace();
			
		}finally { //libero
			sf.close();
		}
	
		
		
	}

}
