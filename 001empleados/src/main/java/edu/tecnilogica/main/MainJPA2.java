package edu.tecnilogica.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;
import edu.tecnilogica.entity.Regions;

public class MainJPA2 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		
		try{
			
			emf = JPAFactory.getEntityManagerFactori();
			EntityManager em = emf.createEntityManager();
			
			//TRANSFORMO A HIBERNATESESSIONFACTORY
			//PASO AL API DE HIBERNATE
			
			SessionFactory sf = emf.unwrap(SessionFactory.class);
			
			Session session = sf.openSession();
			
			Transaction txh = session.beginTransaction();
			
			try{//"Transaccion"
				
				Employees e = session.get(Employees.class, 100);
				System.out.println("Nombre empleado = " + e.getFirstName());
				System.out.println("Salario empleado = " + e.getSalary());
				

				
				txh.commit();
				
				
				
			}catch (Exception e) {
				
				txh.rollback();
				e.printStackTrace();
			}finally {
				em.close();
			}
			
		}catch (Throwable t) {
			t.printStackTrace();
			
		}finally { //libero
			emf.close();
		}
	
		
		
	}

}
